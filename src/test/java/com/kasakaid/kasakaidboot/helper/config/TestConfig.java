package com.kasakaid.kasakaidboot.helper.config;

import com.kasakaid.kasakaidboot.ApplicationTests;
import com.kasakaid.kasakaidboot.helper.resource.MyResource;
import com.kasakaid.kasakaidboot.helper.verify.ISimpleBean;
import com.kasakaid.kasakaidboot.helper.verify.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Profile("test")
@ComponentScan(basePackageClasses = {ApplicationTests.class})
//@TestPropertySource("classpath:application-test.properties")
public class TestConfig {

    @Autowired
    Environment environment;

    @Bean
    public ISimpleBean simpleBean() {
        SimpleBean orderService = new SimpleBean();
        return orderService;
    }

    @Bean
    public TransactionAwareDataSourceProxy dataSource() {
        if ("jdbc:log4jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_ON_EXIT=FALSE".equals(environment.getProperty("spring.datasource.url"))) {
            EmbeddedDatabase ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
            return new TransactionAwareDataSourceProxy(
                    new net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy(ds)
            );
        }
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy proxyDs = new net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy(dataSource);
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return new TransactionAwareDataSourceProxy(proxyDs);
    }

    @Bean
    public MyResource myResource() {
        return new MyResource();
    }
}

