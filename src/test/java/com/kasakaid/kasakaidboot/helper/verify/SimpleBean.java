package com.kasakaid.kasakaidboot.helper.verify;

import org.springframework.boot.test.context.TestComponent;

//@Component
@TestComponent
public class SimpleBean implements ISimpleBean {
    @Override
    public String me() {
        return getClass().getName();
    }
}

