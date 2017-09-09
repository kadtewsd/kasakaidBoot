package com.kasakaid.kasakaidBoot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties
@PropertySource("classpath:/application.properties")
public class Configuration {
    @Value("${key}")
    String url;

    public String getString() {
        return this.url;
    }
}
