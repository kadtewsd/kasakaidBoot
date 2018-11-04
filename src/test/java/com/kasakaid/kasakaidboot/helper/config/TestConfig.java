package com.kasakaid.kasakaidboot.helper.config;

import com.kasakaid.kasakaidboot.ApplicationTests;
import com.kasakaid.kasakaidboot.helper.resource.MyResource;
import com.kasakaid.kasakaidboot.helper.verify.ISimpleBean;
import com.kasakaid.kasakaidboot.helper.verify.SimpleBean;
import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@Configuration
@Profile("test")
@TestConfiguration
@ComponentScan(basePackageClasses = {ApplicationTests.class})
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
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        DataSourceSpy proxyDs = new net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy(dataSource);
        // Autowired した environemnent からキーが発見できない。。
        // log4jdbc が何故かロードできない。
//        dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
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

