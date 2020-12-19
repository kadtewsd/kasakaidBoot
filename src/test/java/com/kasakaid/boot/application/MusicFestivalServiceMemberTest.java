package com.kasakaid.boot.application;

import com.kasakaid.boot.domain.FestivalArtist;
import com.kasakaid.boot.domain.MusicFestival;
import com.kasakaid.boot.domain.artist.Genre;
import com.kasakaid.boot.AbstractBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class MusicFestivalServiceMemberTest extends AbstractBaseTest {

    private Map<Integer, Integer> members;
    @BeforeEach
    public void setUp() {
        super.setup();
        members = new HashMap() {
            {
                put(1, 1);
                put(6, 10);
            }
        };
    }

    @Autowired
    private MusicFestivalService service;

    @Test
    public void アーティストの人数でテスト() throws Exception {
        this.myResource.insertData("music_festival");
        List<MusicFestival> test = service.findByMembers(members)
                .stream()
                .sorted(Comparator.comparing(MusicFestival::getEventDate)
                .thenComparing(MusicFestival::getId))
                .collect(Collectors.toList());
        assertThat(test.size(), is(equalTo(3)));
        MusicFestival metorock = test.get(1); // メトロック
        メトロックの検証(metorock);
        MusicFestival rockin = test.get(2);
        ロッキンジャパンの検証(rockin);
    }

    private void メトロックの検証(MusicFestival musicFestival) {
        assertThat(musicFestival.getName(), is("METROCK 2016"));
        assertThat(musicFestival.getPlace(), is("新木場岩洲公園"));
        assertThat(musicFestival.getEventDate(), is(LocalDate.of(2016, Month.MAY, 21)));
        assertThat(musicFestival.getArtists().size(), is(1));
        FestivalArtist festivalArtist = musicFestival.getArtists().get(0);

        assertThat(festivalArtist.getPlayOrder(), is(6));
        assertThat(festivalArtist.getStart(), is(LocalDateTime.of(2016, Month.MAY, 21, 16, 30, 00)));
        assertThat(festivalArtist.getArtist().getId(), is(11L));
        assertThat(festivalArtist.getArtist().getName(), is("東京スカパラダイスオーケストラ"));
        assertThat(festivalArtist.getArtist().getGenre(), is(Genre.SKA));
    }

    private void ロッキンジャパンの検証(MusicFestival rockin) {
        assertThat(rockin.getName(), is("ROCK IN JAPAN FESTIVAL 2017"));
        assertThat(rockin.getPlace(), is("国営ひたち海浜公園"));
        assertThat(rockin.getEventDate(), is(LocalDate.of(2017, Month.AUGUST, 5)));
        assertThat(rockin.getArtists().size(), is(3));

        FestivalArtist dragonAsh = rockin.getArtists().get(0);
        assertThat(dragonAsh.getPlayOrder(), is(2));
        assertThat(dragonAsh.getStart(), is(LocalDateTime.of(2017, Month.AUGUST, 5, 11, 50, 00)));
        assertThat(dragonAsh.getArtist().getId(), is(15L));
        assertThat(dragonAsh.getArtist().getName(), is("Dragon Ash"));
        assertThat(dragonAsh.getArtist().getGenre(), is(Genre.ROCK));

        FestivalArtist mone = rockin.getArtists().get(1);
        assertThat(mone.getPlayOrder(), is(5));
        assertThat(mone.getStart(), is(LocalDateTime.of(2017, Month.AUGUST, 5, 14, 00, 00)));
        assertThat(mone.getArtist().getId(), is(18L));
        assertThat(mone.getArtist().getName(), is("上白石萌音"));
        assertThat(mone.getArtist().getGenre(), is(Genre.POP));

        FestivalArtist lisa = rockin.getArtists().get(2);
        assertThat(lisa.getPlayOrder(), is(6));
        assertThat(lisa.getStart(), is(LocalDateTime.of(2017, Month.AUGUST, 5, 14, 00, 00)));
        assertThat(lisa.getArtist().getId(), is(19L));
        assertThat(lisa.getArtist().getName(), is("LiSA"));
        assertThat(lisa.getArtist().getGenre(), is(Genre.ROCK));

    }
}