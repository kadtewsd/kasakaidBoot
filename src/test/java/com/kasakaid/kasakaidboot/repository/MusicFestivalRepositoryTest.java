package com.kasakaid.kasakaidboot.repository;

import com.kasakaid.kasakaidboot.KasakaidBootApplication;
import com.kasakaid.kasakaidboot.domain.FestivalArtist;
import com.kasakaid.kasakaidboot.domain.MusicFestival;
import com.kasakaid.kasakaidboot.domain.artist.Artist;
import com.kasakaid.kasakaidboot.domain.artist.Sex;
import com.kasakaid.kasakaidboot.domain.artist.Solo;
import com.kasakaid.kasakaidboot.service.MusicFestivalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@SpringBootTest(classes = KasakaidBootApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MusicFestivalRepositoryTest {

    @MockBean
    MusicFestivalRepository musicFestivalRepository;

    @Before
    public void setUp() {

        MusicFestival festival = MusicFestival.of().id(3L).name("ROCK IN JAPAN Fes 2017").eventDate(
                LocalDate.of(2017, Month.AUGUST, 5)).build();

        Artist solo = new Solo(5L, "Lisa", Sex.Female);
        FestivalArtist festivalArtist = FestivalArtist.of().festivalId(3L).artistId(5L)
                .playOrder(5).start(
                 LocalDateTime.of(2017, Month.AUGUST, 5, 14, 0, 0)).artist(solo).build();
        festival.setArtists(new ArrayList()
                {
                        {
                                add(festivalArtist);
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
        FestivalArtist artist = musicFestival.getArtists().get(0);
//        assertThat(artist..getName(), org.hamcrest.core.Is.is("Lisa"));
//        assertThat(artist.getId(), org.hamcrest.core.Is.is(5L));
    }
}
