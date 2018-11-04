package com.kasakaid.kasakaidboot;

import com.kasakaid.kasakaidboot.helper.config.TestConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationTests.class, TestConfig.class})
@ActiveProfiles("test")
public class ApplicationTests {
}
