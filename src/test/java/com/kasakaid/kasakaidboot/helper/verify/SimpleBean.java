package com.kasakaid.kasakaidboot.helper.verify;

import org.springframework.stereotype.Component;

@Component
// @TestComponent TestComponent ではコンテナに入らない
public class SimpleBean implements ISimpleBean {
    @Override
    public String me() {
        return getClass().getName();
    }
}

