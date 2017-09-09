package com.kasakaid.myboot.verify;

import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Component;

//@Component
@TestComponent
public class SimpleBean implements ISimpleBean {
    @Override
    public String me() {
        return getClass().getName();
    }
}

