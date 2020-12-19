package com.kasakaid.boot.repository;

import com.kasakaid.boot.domain.artist.Artist;
import com.kasakaid.boot.domain.artist.Genre;
import com.kasakaid.boot.domain.artist.MusicGroup;
import com.kasakaid.boot.AbstractBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kasakaid.boot.repository.MemberSpecification.members;
import static com.kasakaid.boot.repository.MemberSpecification.membersByMetamodel;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.typeCompatibleWith;

@Slf4j
public class MusicGroupRepositoryMemberTest extends AbstractBaseTest {

    private Map<Integer, Integer> members;

    @BeforeEach
    public void setUp() {
        super.setup();
        members = new HashMap() {
            {
                put(2, 2);
                put(8, 10);
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
        List<MusicGroup> test = groupRepository.findAll(
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
        List<MusicGroup> test = groupRepository.findAll(
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
        assertThat(artist.getGenre(), is(Genre.SKA));
        assertThat(artist.getClass(), typeCompatibleWith(MusicGroup.class));
        MusicGroup musicGroup = (MusicGroup) artist;
        assertThat(musicGroup.getMembers(), is(10));
    }

    public static void dragonAsh(Artist dragonAsh) {
        assertThat(dragonAsh.getId(), is(15L));
        assertThat(dragonAsh.getName(), is("Dragon Ash"));
        assertThat(dragonAsh.getGenre(), is(Genre.ROCK));

        assertThat(dragonAsh.getClass(), typeCompatibleWith(MusicGroup.class));
        MusicGroup musicGroup = (MusicGroup) dragonAsh;
        assertThat(musicGroup.getMembers(), is(8));
    }

    public static void bz(Artist bz) {
        assertThat(bz.getId(), is(22L));
        assertThat(bz.getName(), is("B'z"));
        assertThat(bz.getGenre(), is(Genre.HARD_ROCK));

        assertThat(bz.getClass(), typeCompatibleWith(MusicGroup.class));
        MusicGroup musicGroup = (MusicGroup) bz;
        assertThat(musicGroup.getMembers(), is(2));
    }

    public static <T extends Artist> void logArtist(List<T> artists) {
        artists.forEach(x -> log.info("ID {} Name {}", x.getId(), x.getName()));
    }
}