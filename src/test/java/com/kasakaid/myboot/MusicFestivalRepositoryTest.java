package com.kasakaid.myboot;

import com.kasakaid.kasakaidBoot.KasakaidBootApplication;
import com.kasakaid.kasakaidBoot.domain.Artist;
import com.kasakaid.kasakaidBoot.domain.MusicFestival;
import com.kasakaid.kasakaidBoot.repository.MusicFestivalRepository;
import com.kasakaid.kasakaidBoot.service.MusicFestivalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@SpringBootTest(classes = KasakaidBootApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MusicFestivalRepositoryTest {

    @MockBean
    MusicFestivalRepository musicFestivalRepository;

    @Before
    public void setUp() {
        MusicFestival festival = new MusicFestival();

        festival.setId(3L);
        festival.setName("ROCK IN JAPAN Fes 2017");
        festival.setEventDate(new GregorianCalendar(2017, 8, 5).getTime());
        festival.setArtists(new LinkedList() {
            {
                add(new Artist(5L, 3, "Lisa", 5, new GregorianCalendar(
                        2017, 8, 5, 14, 0, 0).getTime()
                        , festival
                ));
            }
        });
        Mockito.when(musicFestivalRepository.findById(3L))
                .thenReturn(festival);
    }
    @TestConfiguration
    static class MusicFestivalServiceImplTestContextConfiguration {

    }

    @Autowired
    private MusicFestivalService service;

    @Test
    public void モックのテスト() {
        MusicFestival musicFestival = service.findOne(3L);
        assertThat(musicFestival, notNullValue());
        assertThat(musicFestival.getName(), org.hamcrest.core.Is.is("ROCK IN JAPAN Fes 2017"));
        assertThat(musicFestival.getId(), org.hamcrest.core.Is.is(3L));
        Artist artist = musicFestival.getArtists().get(0);
        assertThat(artist.getName(), org.hamcrest.core.Is.is("Lisa"));
        assertThat(artist.getArtistId(), org.hamcrest.core.Is.is(5L));
        assertThat(artist.getFestivalId(), org.hamcrest.core.Is.is(3L));
    }
}