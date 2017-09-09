package com.kasakaid.myboot.config;

import com.kasakaid.myboot.base.MyResource;
import com.kasakaid.myboot.verify.ISimpleBean;
import com.kasakaid.myboot.verify.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@Configuration
@ComponentScan(basePackages = {"com.kasakaid.myboot"})
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
        // environemnent からキーが発見できない。。
//        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
//        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
//        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
//        dataSource.setPassword(environment.getProperty("spring.datasource.password"));

        // log4jdbc が何故かロードできない。
//        dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//        dataSource.setUrl("jdbc:log4jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_ON_EXIT=FALSE");

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_ON_EXIT=FALSE");

        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return new TransactionAwareDataSourceProxy(dataSource);
    }
    @Bean
    public MyResource myResource() {
        return new MyResource();
    }
}
