package com.kasakaid.kasakaidboot;


import org.springframework.core.env.Environment;

public class Properties {

    private static Environment environment;

    public static void SetEnvironemnet(Environment env) {
        environment = env;
    }

    public static String getProperty(String key) {
        return environment.getProperty(key);
    }
}
