package com.kasakaid.boot.spring;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

@Slf4j
public class MyNamingStrategy extends SpringPhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        log.info("table canonical : {} logical : {}", name.getCanonicalName(), name.getText());
        Identifier result = super.toPhysicalTableName(name, context);
        log.info("changed |||||| table canonical : {} logical : {}", result.getCanonicalName(), result.getText());
        return result;
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
//        log.info(identifier.getCanonicalName()); ヌルポになるのでこの戦略は使えない。
        log.info("pre ### column canonical : {} logical : {}", name.getCanonicalName(), name.getText());
        Identifier result = super.toPhysicalColumnName(name, context);
        log.info("changed |||| column canonical : {} logical : {}", result.getCanonicalName(), result.getText());
        return result;
    }
}
