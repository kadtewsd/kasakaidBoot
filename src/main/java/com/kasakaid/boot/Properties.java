package com.kasakaid.boot;


import org.springframework.core.env.Environment;

public class Properties {

    private static Environment environment;

    public static void setEnvironment(Environment env) {
        environment = env;
    }

    public static String getProperty(String key) {
        return environment.getProperty(key);
    }
}
