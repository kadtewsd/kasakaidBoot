package com.kasakaid.kasakaidboot.helper;

import com.kasakaid.kasakaidboot.KasakaidBootApplication;
import com.kasakaid.kasakaidboot.helper.config.TestConfig;
import com.kasakaid.kasakaidboot.helper.resource.MyResource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {KasakaidBootApplication.class, TestConfig.class})
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@Slf4j
public abstract class AbstractBaseTest {

    @Autowired
    protected ApplicationContext context;

    // 実行順序がよくわからないのでサブクラスからコールする
    public void setup() {
    }

    @Autowired
    //public にしないと怒られる
    public MyResource myResource;
}
