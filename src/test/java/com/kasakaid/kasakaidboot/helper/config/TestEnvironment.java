package com.kasakaid.kasakaidboot.helper.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@TestConfiguration
@Profile("test")
@PropertySource("classpath:application-test.properties")
public class TestEnvironment {
}
