package com.kasakaid.boot.spring;

import com.kasakaid.boot.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SpringEventHandler implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("we set environment object...");
        Properties.setEnvironment(event.getApplicationContext().getEnvironment());
    }
}
