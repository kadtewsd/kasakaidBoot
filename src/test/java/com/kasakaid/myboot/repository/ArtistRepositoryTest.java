package com.kasakaid.myboot.repository;

import com.kasakaid.kasakaidBoot.domain.artist.Artist;
import com.kasakaid.kasakaidBoot.domain.artist.Sex;
import com.kasakaid.kasakaidBoot.domain.artist.Solo;
import com.kasakaid.kasakaidBoot.repository.ArtistRepository;
import com.kasakaid.myboot.helper.AbstractBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kasakaid.kasakaidBoot.repository.ArtistSpecification.artistMembers;
import static com.kasakaid.kasakaidBoot.repository.ArtistSpecification.artistWithId;
import static com.kasakaid.myboot.repository.GroupRepositoryMemberTest.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.data.jpa.domain.Specifications.where;

@Slf4j
public class ArtistRepositoryTest extends AbstractBaseTest {

    private Map<Integer, Integer> members;
    @Before
    public void setUp() {
        super.setup();
        members = new HashMap() {
            {
                put(1, 2);
                put(6, 7);
            }
        };
    }

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    public void アーティストの人数でテスト() throws Exception {
        this.myResource.insertData("music_festival");
//        List<Artist> test = groupRepository.findAll(
//                members(this.members));
        List<Artist> test = artistRepository.findAll(
                where(artistMembers(this.members)));
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
//        List<Artist> test = groupRepository.findAll(
//                members(this.members));
        List<Artist> test = artistRepository.findAll(
                where(artistWithId(this.members)));
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

    public static void 上白石(Artist mone) {
        assertThat(mone.getId(), is(18L));
        assertThat(mone.getName(), is("上白石萌音"));
        assertThat(mone.getGenre().getId(), is(3));
        assertThat(mone.getGenre().getName(), is("POP"));
        assertThat(mone.getClass(), typeCompatibleWith(Solo.class));
        Solo solo = (Solo) mone;
        assertThat(solo.getSex(), is(Sex.Female));

    }

    public static void lisa(Artist lisa) {
        assertThat(lisa.getId(), is(19L));
        assertThat(lisa.getName(), is("LiSA"));
        assertThat(lisa.getGenre().getId(), is(1));
        assertThat(lisa.getGenre().getName(), is("ROCK"));
        assertThat(lisa.getClass(), typeCompatibleWith(Solo.class));
        Solo solo = (Solo) lisa;
        assertThat(solo.getSex(), is(Sex.Female));
    }
}