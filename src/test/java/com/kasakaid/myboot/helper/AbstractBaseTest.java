package com.kasakaid.myboot.helper;

import com.kasakaid.kasakaidBoot.KasakaidBootApplication;
import com.kasakaid.myboot.helper.config.TestConfig;
import com.kasakaid.myboot.helper.resource.MyResource;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = KasakaidBootApplication.class)
@ActiveProfiles("test")
public abstract class AbstractBaseTest {

    @Autowired
    protected ApplicationContext context;

    protected ApplicationContext testConfigApplication;

    // 実行順序がよくわからないのでサブクラスからコールする
//    @Before
    public void setup() {
        testConfigApplication = new AnnotationConfigApplicationContext(TestConfig.class);
        myResource = testConfigApplication.getBean(MyResource.class);
    }
        @Rule
        //public にしないと怒られる
        public MyResource myResource;
}