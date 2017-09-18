package com.kasakaid.myboot.configuration;

import com.kasakaid.kasakaidBoot.Properties;
import com.kasakaid.myboot.helper.AbstractBaseTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ApplicationPropertiesTest extends AbstractBaseTest {

    @Test
    public void applicationPropertiesの読み込み() {
        assertThat(Properties.getProperty("common.key"), is("hoge"));
    }

    @Test
    public void テストのみのキーのテスト() {
        assertThat(Properties.getProperty("test.key"), is("this_is_test_key"));
    }
}
