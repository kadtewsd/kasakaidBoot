package com.kasakaid.myboot.repository;

import com.kasakaid.kasakaidBoot.domain.artist.Artist;
import com.kasakaid.kasakaidBoot.domain.artist.Group;
import com.kasakaid.kasakaidBoot.repository.GroupRepository;
import com.kasakaid.myboot.helper.AbstractBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kasakaid.kasakaidBoot.repository.MemberSpecification.members;
import static com.kasakaid.kasakaidBoot.repository.MemberSpecification.membersByMetamodel;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Slf4j
public class GroupRepositoryMemberTest extends AbstractBaseTest {

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
    private GroupRepository groupRepository;

    @Test
    public void アーティストの人数でテスト() throws Exception {
        this.myResource.insertData("music_festival");
//        List<Artist> test = groupRepository.findAll(
//                members(this.members));
        List<Group> test = groupRepository.findAll(
                members(this.members));
        logArtist(test);
        assertThat(test.size(), is(equalTo(3)));
        Artist sukapara = test.get(0); // 東京スカらパラダイス
        東京スカパラダイスオーケストラ(sukapara);
        Artist dragonAsh = test.get(1);
        dragonAsh(dragonAsh);
        Artist bz = test.get(2);
        bz(bz);
    }

    @Test
    public void アーティストの人数をメタモデルでテスト() throws Exception {
        this.myResource.insertData("music_festival");
//        List<Artist> test = groupRepository.findAll(
//                members(this.members));
        List<Group> test = groupRepository.findAll(
                membersByMetamodel(this.members));
        logArtist(test);
        assertThat(test.size(), is(equalTo(3)));
        Artist sukapara = test.get(0); // 東京スカらパラダイス
        東京スカパラダイスオーケストラ(sukapara);
        Artist dragonAsh = test.get(1);
        dragonAsh(dragonAsh);
        Artist bz = test.get(2);
        bz(bz);
    }

    public static void 東京スカパラダイスオーケストラ(Artist artist) {
        assertThat(artist.getId(), is(11L));
        assertThat(artist.getName(), is("東京スカパラダイスオーケストラ"));
        assertThat(artist.getGenre().getId(), is(8));
        assertThat(artist.getGenre().getName(), is("SKA"));
    }

    public static void dragonAsh(Artist dragonAsh) {
        assertThat(dragonAsh.getId(), is(15L));
        assertThat(dragonAsh.getName(), is("Dragon Ash"));
        assertThat(dragonAsh.getGenre().getId(), is(1));
        assertThat(dragonAsh.getGenre().getName(), is("ROCK"));

    }

   public static void bz(Artist bz) {
        assertThat(bz.getId(), is(22L));
        assertThat(bz.getName(), is("B'z"));
        assertThat(bz.getGenre().getId(), is(7));
        assertThat(bz.getGenre().getName(), is("Heavy Metal"));
    }

    public static  <T extends Artist> void logArtist(List<T> artists) {
        artists.forEach(x -> log.info("ID {} Name {}", x.getId(), x.getName()));
    }
}