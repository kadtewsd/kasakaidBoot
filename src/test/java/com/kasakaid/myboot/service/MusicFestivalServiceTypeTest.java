package com.kasakaid.myboot.service;

import com.kasakaid.kasakaidBoot.domain.FestivalArtist;
import com.kasakaid.kasakaidBoot.domain.MusicFestival;
import com.kasakaid.kasakaidBoot.domain.artist.Pop;
import com.kasakaid.kasakaidBoot.domain.artist.Punk;
import com.kasakaid.kasakaidBoot.domain.artist.Rock;
import com.kasakaid.kasakaidBoot.service.MusicFestivalService;
import com.kasakaid.myboot.helper.AbstractBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class MusicFestivalServiceTypeTest extends AbstractBaseTest {

    @Before
    public void setUp() {
        super.setup();
    }

    @Autowired
    private MusicFestivalService service;

    @Test
    public void 取得したアーティストのタイプをテスト() throws Exception {
        this.myResource.insertData("music_festival");
        List<MusicFestival> test = service.findAll();
        assertThat(test.size(), is(greaterThan(0)));
        assertThat(test.size(), is(equalTo(1 )));
        validateArtists(test.get(0).getArtists());
        logType(test.get(0).getArtists());
    }

    private void validateArtists(List<FestivalArtist> artists) {
        assertThat(artists, notNullValue());
        assertThat(artists.size(), is(equalTo(9 )));
        assertThat(artists.get(0).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(1).getArtist().getClass(), typeCompatibleWith(Punk.class));
        assertThat(artists.get(2).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(3).getArtist().getClass(), typeCompatibleWith(Pop.class));
        assertThat(artists.get(4).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(5).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(6).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(7).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(8).getArtist().getClass(), typeCompatibleWith(Rock.class));
    }

    private void logType(List<FestivalArtist> artists) {
        artists.forEach(x -> log.info("{} is {}", x.getArtist().getName(), x.getArtist().getClass()));
    }
}