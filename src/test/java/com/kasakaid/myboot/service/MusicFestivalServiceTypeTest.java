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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
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
        assertThat(test.size(), is(equalTo(1)));
        validateArtists(test.get(0).getArtists());
        validateDuplicateArtist(test.get(0).getArtists());
        logType(test.get(0).getArtists());
    }

    private void validateArtists(List<FestivalArtist> artists) {
        assertThat(artists, notNullValue());
        assertThat(artists.size(), is(equalTo(11)));
        assertThat(artists.get(0).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(1).getArtist().getClass(), typeCompatibleWith(Punk.class));
        assertThat(artists.get(2).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(3).getArtist().getClass(), typeCompatibleWith(Pop.class));
        assertThat(artists.get(4).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(5).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(6).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(7).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(8).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(9).getArtist().getClass(), typeCompatibleWith(Rock.class));
        assertThat(artists.get(10).getArtist().getClass(), typeCompatibleWith(Rock.class));
    }

    /**
     * 注意事項
     * FestivalArtist の一意性は、festivalId, artsitId, playOrder で決まる。
     * @IdClass に指定している主キー属性に playOrder が存在しない場合、重複しているアーティスト (ASIAN KUNG-FU GENERATION)
     * の FestivalArtist (出演順、出演時刻の情報) は 2 つのレコードとも、playOrder が若いレコード (playOrder :10, 出演時刻 20:00)
     * になってしまう。(出演順 11 の最後のレコードは、"unread" とログ出力される)
     * 主キーについては厳密に定義しないと想定外のレコードが返ってくるので、注意する。
     */
    private void validateDuplicateArtist(List<FestivalArtist> artists) {
        assertThat(artists.get(9).getPlayOrder(), is(10));
        assertThat(artists.get(9).getStart(), is(LocalDateTime.of(2015, Month.MAY, 3, 20, 00, 00)));
        assertThat(artists.get(10).getPlayOrder(), is(11));
        assertThat(artists.get(10).getStart(), is(LocalDateTime.of(2015, Month.MAY, 3, 20, 30, 00)));
    }
    private void logType(List<FestivalArtist> artists) {
        artists.forEach(festivalArtist -> {
            log.info("{} is {}",
                    festivalArtist.getArtist().getName(),
                    festivalArtist.getArtist().getClass());
            log.info("playOrder is {} start is {}",
                    festivalArtist.getPlayOrder(),
                    festivalArtist.getStart());
        });
    }
}