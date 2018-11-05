package com.kasakaid.kasakaidboot.application;

import com.kasakaid.kasakaidboot.domain.FestivalArtist;
import com.kasakaid.kasakaidboot.domain.MusicFestival;
import com.kasakaid.kasakaidboot.helper.AbstractBaseTest;
import com.kasakaid.kasakaidboot.helper.verify.ISimpleBean;
import com.kasakaid.kasakaidboot.helper.verify.SimpleBean;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

// No suitable driver found for jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_ON_EXIT=FALSE
//@ContextConfiguration(classes ={KasakaidBootApplication.class, TestConfig.class})
//MusicFestivalService が NoSuchDefenitionerror
//@ContextConfiguration(classes ={TestConfig.class}, loader = AnnotationConfigContextLoader.class)
//@ContextConfiguration(classes ={KasakaidBootApplication.class})
//@SqlGroup({
//        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql"),
//        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:data.sql")
//})
public class MusicFestivalServiceTest extends AbstractBaseTest {

    @Before
    public void setUp() {
        super.setup();
        // Autowired の ApplicationContext では Bean は見つからない
    }

    // テストクラスのBeanを Autowired しようとすると「NoSuchBeanDefinitionException」になる。
    // TestConfig の ComponentScan が効いている気配がない。
    // 下記のページでインターフェースでやると良いとあるが、インターフェースを使ってやってもだめ。
    //https://stackoverflow.com/questions/3413639/how-to-get-spring-to-autowire-integration-test-class-using-multiple-contexts
    @Autowired
    private ISimpleBean simpleBean;
    @Autowired
    private MusicFestivalService service;

    @Test
    public void test1() throws Exception {
        this.myResource.insertData("music_festival");
        List<MusicFestival> test = service.findAll()
                .stream()
                .sorted(Comparator.comparing(MusicFestival::getEventDate)
                        .thenComparing(MusicFestival::getId))
                .collect(Collectors.toList());
        assertThat(test.size(), is(greaterThan(0)));
        assertThat(test.size(), is(equalTo(3)));
        assertThat(test.get(0).getName(), is("JAPAN JAM BEACH 2015"));
        validateArtists(test.get(0).getArtists());
    }

    @Test
    @SneakyThrows
    public void test2() {
        this.myResource.insertData("music_festival");
        MusicFestival test = service.findOne(1L);
        assertThat(test, notNullValue());
        assertThat(test.getArtists(), notNullValue());
        assertThat(test.getArtists().size(), is(equalTo(11)));
        validateArtists(test.getArtists());
    }

    private void validateArtists(List<FestivalArtist> artists) {
        assertThat(artists, notNullValue());
        assertThat(artists.size(), is(equalTo(11)));
        assertThat(artists.get(0).getArtist().getName(), is("Base Ball Bear"));
        assertThat(artists.get(1).getArtist().getName(), is("サンボマスター"));
        assertThat(artists.get(2).getArtist().getName(), is("the telephones"));
        assertThat(artists.get(3).getArtist().getName(), is("パスピエ"));
        assertThat(artists.get(4).getArtist().getName(), is("the band apart"));
        assertThat(artists.get(5).getArtist().getName(), is("空想委員会"));
        assertThat(artists.get(6).getArtist().getName(), is("Polysics"));
        assertThat(artists.get(7).getArtist().getName(), is("ACIDMAN"));
        assertThat(artists.get(8).getArtist().getName(), is("ZAZEN BOYS"));
        assertThat(artists.get(9).getArtist().getName(), is("ASIAN KUNG-FU GENERATION"));
        assertThat(artists.get(10).getArtist().getName(), is("ASIAN KUNG-FU GENERATION"));
    }

    @Test
    public void テストクラスのBean化() {
        assertThat(simpleBean, notNullValue());
        assertThat(simpleBean.me(), is(SimpleBean.class.getName()));
    }

}