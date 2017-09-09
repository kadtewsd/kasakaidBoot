package com.kasakaid.myboot;

import com.kasakaid.kasakaidBoot.Configuration;
import com.kasakaid.kasakaidBoot.KasakaidBootApplication;
import com.kasakaid.kasakaidBoot.domain.MusicFestival;
import com.kasakaid.kasakaidBoot.service.MusicFestivalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {KasakaidBootApplication.class})
//@SqlGroup({
//        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql"),
//        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:data.sql")
//})
public class MusicFestivalServiceTest {

    @Autowired
    private Configuration config;

//    @Rule
//    @Autowired
//    //public にしないと怒られる
//    public DBUnit dbUnit;

    @Autowired
    private MusicFestivalService service;
    @Test
    public void test1() {
        List<MusicFestival> test = service.findAll();
        assertThat(test.size(), is(greaterThan(0)));
        assertThat(test.size(), is(equalTo(6)));
    }

    @Test
    public void test2() {
        List<MusicFestival> test = service.findOne(1L);
        assertThat(test, notNullValue());
        //assertThat(test.size(), is(equalTo(1)));
    }

}