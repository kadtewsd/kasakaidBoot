package com.kasakaid.kasakaidboot.configuration;

import com.kasakaid.kasakaidboot.Properties;
import com.kasakaid.kasakaidboot.helper.AbstractBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@Slf4j
public class ApplicationPropertiesTest extends AbstractBaseTest {

    @Test
    public void applicationPropertiesの読み込み() {
        assertThat(Properties.getProperty("common.key"), is("this_is_common"));
    }

    @Test
    public void テストのみのキーのテスト() {
        assertThat(Properties.getProperty("test.key"), is("this_is_test_key"));
    }

//    @Test(expected = IllegalArgumentException.class)
    @Test
    public void 開発環境のキーは取得できないテスト() {
        assertThat(Properties.getProperty("development.key"), nullValue());
    }
}