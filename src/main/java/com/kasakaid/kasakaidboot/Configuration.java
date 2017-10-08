package com.kasakaid.kasakaidboot;

//@Component
//@ConfigurationProperties
//@PropertySource("classpath:/application.properties")
public class Configuration {
//    @Value("${key}")
    String url;

    public String getString() {
        return this.url;
    }
}
