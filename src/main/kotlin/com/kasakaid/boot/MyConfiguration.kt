package com.kasakaid.boot

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment

//@Component
//@ConfigurationProperties
//@PropertySource("classpath:/application.properties")
@Configuration
class MyConfiguration {
    @Bean
    fun check(env: Environment): List<String?> {

        val development1 = env.getProperty("include1.development")
        val development2 = env.getProperty("include2.development")
        val test = env.getProperty("include.test")
        val profileNameFileKey = env.getProperty("duplicate.key")

        if (env.activeProfiles.any { it == "development" }) {
            require(development1 == "include1。developmentプロファイルにより参照(ymlなのでUTF-8エンコードできています)") { "間接的なインクルードができていません" }
            require(development2 == "include2。developmentプロファイルにより参照(ymlなのでUTF-8エンコードできています)") { "間接的なインクルードができていません" }
            require(profileNameFileKey == "I'm a development") { "プロファイルと同じ名前のファイル名を読み込めていません。" }
            require(test.isNullOrEmpty()) { "development の時に test が読み込まれています。" }
        } else {
            require(development1.isNullOrEmpty()) { "test の時に、development が読み込まれています。" }
            require(development2.isNullOrEmpty()) { "test の時に、development が読み込まれています。" }
            require(test == "this_is_test_key") { "間接的にテストのキーをインクルードできていません。" }
            require(profileNameFileKey == "I'm a test") { "プロファイルと同じ名前のファイルが読み込まれていません。" }
        }

        return listOf(development1, development2, test, profileNameFileKey)
    }
}
