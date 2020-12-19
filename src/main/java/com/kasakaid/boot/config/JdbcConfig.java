package com.kasakaid.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);

        ResourceDatabasePopulator functionPopulator = new ResourceDatabasePopulator(
        );
        //new ClassPathResource("function.sql"));
        //functionPopulator.setSeparator(";/");

//        ResourceDatabasePopulator generalPopulator = new ResourceDatabasePopulator(
//                new ClassPathResource("schema.sql"),
//                new ClassPathResource("db/migration/data.sql"));

//        initializer.setDatabasePopulator(new CompositeDatabasePopulator(functionPopulator, generalPopulator));

        return initializer;
    }
}

