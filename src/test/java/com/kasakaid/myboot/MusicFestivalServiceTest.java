package com.kasakaid.myboot;

import com.kasakaid.kasakaidBoot.KasakaidBootApplication;
import com.kasakaid.kasakaidBoot.domain.Artist;
import com.kasakaid.kasakaidBoot.domain.MusicFestival;
import com.kasakaid.kasakaidBoot.service.MusicFestivalService;
import com.kasakaid.myboot.base.MyResource;
import com.kasakaid.myboot.config.TestConfig;
import com.kasakaid.myboot.verify.ISimpleBean;
import com.kasakaid.myboot.verify.SimpleBean;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
// No suitable driver found for jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_ON_EXIT=FALSE
//@ContextConfiguration(classes ={KasakaidBootApplication.class, TestConfig.class})
//MusicFestivalService が NoSuchDefenitionerror
//@ContextConfiguration(classes ={TestConfig.class}, loader = AnnotationConfigContextLoader.class)
//@ContextConfiguration(classes ={KasakaidBootApplication.class})
//@SqlGroup({
//        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql"),
//        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:data.sql")
//})
@SpringBootTest(classes = KasakaidBootApplication.class)
public class MusicFestivalServiceTest {

    @Before
    public void setup() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);
        myResource = context.getBean(MyResource.class);
        simpleBean = context.getBean(ISimpleBean.class);
    }

    @Rule
    //public にしないと怒られる
    public MyResource myResource;

    // テストクラスのBeanを Autowired しようとすると「NoSuchBeanDefinitionException」になる。
    // TestConfig の ComponentScan が効いている気配がない。
    // 下記のページでインターフェースでやると良いとあるが、インターフェースを使ってやってもだめ。
    //https://stackoverflow.com/questions/3413639/how-to-get-spring-to-autowire-integration-test-class-using-multiple-contexts
//    @Autowired
    private ISimpleBean simpleBean;
    @Autowired
    private MusicFestivalService service;

    @Test
    public void test1() throws Exception {
        this.myResource.insertData("music_festival");
        List<MusicFestival> test = service.findAll();
        assertThat(test.size(), is(greaterThan(0)));
        assertThat(test.size(), is(equalTo(1 )));
        assertThat(test.get(0).getArtists(), notNullValue());
        assertThat(test.get(0).getArtists().size(), is(equalTo(9 )));
        assertThat(test.get(0).getArtists().get(0).getArtist(), nullValue());
        assertThat(test.get(0).getArtists().get(1).getArtist(), nullValue());
        assertThat(test.get(0).getArtists().get(2).getArtist(), nullValue());
        assertThat(test.get(0).getArtists().get(3).getArtist(), nullValue());
        assertThat(test.get(0).getArtists().get(4).getArtist(), nullValue());
        assertThat(test.get(0).getArtists().get(5).getArtist(), nullValue());
        assertThat(test.get(0).getArtists().get(6).getArtist(), nullValue());
        assertThat(test.get(0).getArtists().get(7).getArtist(), nullValue());
        assertThat(test.get(0).getArtists().get(8).getArtist(), nullValue());
    }

    @Test
    @SneakyThrows
    public void test2() {
        this.myResource.insertData("music_festival");
        MusicFestival test = service.findOne(1L);
        assertThat(test, notNullValue());
        assertThat(test.getArtists(), notNullValue());
        assertThat(test.getArtists().size(), is(equalTo(9 )));
    }

    @Test
    public void テストクラスのBean化() {
        assertThat(simpleBean, notNullValue());
        assertThat(simpleBean.me(), is(SimpleBean.class.getName()));
    }

}