package com.kasakaid.kasakaidBoot.spring;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

@Slf4j
public class MyNamingStrategy extends SpringPhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        log.info(name.getCanonicalName());
        return super.toPhysicalTableName(name, context);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
//        log.info(identifier.getCanonicalName()); ヌルポになるのでこの戦略は使えない。
        log.info(name.getCanonicalName());
        log.info(name.getText());
        return super.toPhysicalColumnName(name, context);
    }
}
