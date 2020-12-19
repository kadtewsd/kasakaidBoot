package com.kasakaid.boot.configuration

import com.kasakaid.boot.AbstractBaseTest
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment

class ApplicationPropertiesTest : AbstractBaseTest() {

    @Autowired
    lateinit var env: Environment

    @Test
    fun applicationPropertiesの読み込み() {
        assertThat(env.getProperty("common.key"), `is`("this_is_common"))
    }

    @Test
    fun テストのみのキーのテスト() {
        assertThat(env.getProperty("include.test"), `is`("this_is_test_key"))
    }

    @Test
    fun testのプロパティファイルにのみ記述されている内容を取得できる() {
        assertThat(env.getProperty("include.test"), `is`("this_is_test_key"))
    }

    @Test
    fun プロファイルと同じ滑のファイルのキーを取得できる() {
        assertThat(env.getProperty("duplicate.key"), `is`("I'm a test"))
    }

    @Test
    fun developmentのキーはnullになる() {
        assertThat(env.getProperty("include1.development"), `is`(nullValue()))
        assertThat(env.getProperty("include2.development"), `is`(nullValue()))
    }

    //    @Test(expected = IllegalArgumentException.class)
    @Test
    fun 開発環境のキーは取得できないテスト() {
        assertThat(env.getProperty("development.key"), nullValue())
    }
}