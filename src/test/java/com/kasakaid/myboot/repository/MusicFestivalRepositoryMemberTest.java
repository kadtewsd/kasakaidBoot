package com.kasakaid.myboot.repository;

import com.kasakaid.kasakaidBoot.domain.MusicFestival;
import com.kasakaid.kasakaidBoot.domain.artist.Artist;
import com.kasakaid.kasakaidBoot.domain.artist.Group;
import com.kasakaid.kasakaidBoot.repository.GroupRepository;
import com.kasakaid.kasakaidBoot.repository.MusicFestivalMemberRepository;
import com.kasakaid.myboot.helper.AbstractBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kasakaid.myboot.repository.GroupRepositoryMemberTest.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Slf4j
public class MusicFestivalRepositoryMemberTest extends AbstractBaseTest {

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
    private MusicFestivalMemberRepository musicFestivalMemberRepository;

    @Test
    public void アーティストの人数でテスト() throws Exception {
        this.myResource.insertData("music_festival");
////        List<Artist> test = groupRepository.findAll(
////                members(this.members));
//        List<Artist> test = musicFestivalMemberRepository.findByMembers(
//                members(this.members));
//        logArtist(test);
//        assertThat(test.size(), is(equalTo(5)));
//        Artist sukapara = test.get(0); // 東京スカらパラダイス
//        東京スカパラダイスオーケストラ(sukapara);
//        Artist kamisiraishi = test.get(1);
//        上白石(kamisiraishi);
//        Artist dragonAsh = test.get(2);
//        dragonAsh(dragonAsh);
//        Artist lisa = test.get(3);
//        lisa(lisa);
//        Artist bz = test.get(4);
//        bz(bz);
    }

    public static void 上白石(Artist mone) {
        assertThat(mone.getId(), is(18));
        assertThat(mone.getName(), is("上白石萌音"));
        assertThat(mone.getGenre().getId(), is(3));
        assertThat(mone.getGenre().getName(), is("POP"));
    }

    public static void lisa(Artist lisa) {
        assertThat(lisa.getId(), is(19));
        assertThat(lisa.getName(), is("LiSA"));
        assertThat(lisa.getGenre().getId(), is(1));
        assertThat(lisa.getGenre().getName(), is("ROCK"));
    }
}