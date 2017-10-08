package com.kasakaid.kasakaidboot.helper.config;

import com.kasakaid.kasakaidboot.Properties;
import com.kasakaid.kasakaidboot.helper.resource.MyResource;
import com.kasakaid.kasakaidboot.helper.verify.ISimpleBean;
import com.kasakaid.kasakaidboot.helper.verify.SimpleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

//@Configuration
@TestConfiguration
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
        // Autowired した environemnent からキーが発見できない。。
        // log4jdbc が何故かロードできない。
//        dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        dataSource.setDriverClassName(Properties.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(Properties.getProperty("spring.datasource.url"));
        dataSource.setUsername(Properties.getProperty("spring.datasource.username"));
        dataSource.setPassword(Properties.getProperty("spring.datasource.password"));

        return new TransactionAwareDataSourceProxy(dataSource);
    }

    @Bean
    public MyResource myResource() {
        return new MyResource();
    }
}

