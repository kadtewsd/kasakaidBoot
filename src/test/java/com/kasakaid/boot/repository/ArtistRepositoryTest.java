package com.kasakaid.boot.repository;

import com.kasakaid.boot.domain.MusicFestival;
import com.kasakaid.boot.domain.artist.Artist;
import com.kasakaid.boot.domain.artist.Genre;
import com.kasakaid.boot.domain.artist.Sex;
import com.kasakaid.boot.domain.artist.Solo;
import com.kasakaid.boot.AbstractBaseTest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kasakaid.boot.repository.ArtistSpecification.*;
import static com.kasakaid.boot.repository.MusicGroupRepositoryMemberTest.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.data.jpa.domain.Specification.*;

@Slf4j
public class ArtistRepositoryTest extends AbstractBaseTest {

    private Map<Integer, Integer> members;
    @BeforeEach
    public void setUp() {
        super.setup();
        members = new HashMap() {
            {
                put(1, 2);
                put(6, 10);
            }
        };
    }

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MusicFestivalRepository musicFestivalRepository;

    private List<Artist> find() {
        List<Artist> result = artistRepository.findAll(
                where(artistWithId(this.members)));
        return result
                .stream()
                .sorted(Comparator.comparing(Artist::getId))
                .collect(Collectors.toList());
    }
    @Test
    public void アーティストの人数でテスト() throws Exception {
        this.myResource.insertData("music_festival");
        List<Artist> test = find();
        logArtist(test);
        assertThat(test.size(), is(equalTo(5)));
        Artist sukapara = test.get(0); // 東京スカパラダイス
        東京スカパラダイスオーケストラ(sukapara);
        Artist dragonAsh = test.get(1);
        dragonAsh(dragonAsh);
        Artist kamisiraishi = test.get(2);
        上白石(kamisiraishi);
        Artist lisa = test.get(3);
        lisa(lisa);
        Artist bz = test.get(4);
        bz(bz);
    }

    @Test
    public void IDでアーティストの人数でテスト() throws Exception {
        this.myResource.insertData("music_festival");
        List<Artist> test = find();
        logArtist(test);
        assertThat(test.size(), is(equalTo(5)));
        Artist sukapara = test.get(0); // 東京スカらパラダイス
        東京スカパラダイスオーケストラ(sukapara);
        Artist dragonAsh = test.get(1);
        dragonAsh(dragonAsh);
        Artist kamisiraishi = test.get(2);
        上白石(kamisiraishi);
        Artist lisa = test.get(3);
        lisa(lisa);
        Artist bz = test.get(4);
        bz(bz);
    }

    @SneakyThrows
    @Test
    public void MusicFestivalTest() {
        this.myResource.insertData("music_festival");
        List<MusicFestival> musicFestivals = musicFestivalRepository.findAll();
        System.out.println(musicFestivals);
    }

    public static void 上白石(Artist mone) {
        assertThat(mone.getId(), is(18L));
        assertThat(mone.getName(), is("上白石萌音"));
        assertThat(mone.getGenre(), is(Genre.POP));
        assertThat(mone.transform().getClass(), typeCompatibleWith(Solo.class));
        Solo solo = (Solo) mone.transform();
        assertThat(solo.getSex(), is(Sex.Female));

    }

    public static void lisa(Artist lisa) {
        assertThat(lisa.getId(), is(19L));
        assertThat(lisa.getName(), is("LiSA"));
        assertThat(lisa.getGenre(), is(Genre.ROCK));
        assertThat(lisa.transform().getClass(), typeCompatibleWith(Solo.class));
        Solo solo = (Solo) lisa.transform();
        assertThat(solo.getSex(), is(Sex.Female));
    }
}