package com.kasakaid.kasakaidboot.domain;

import com.kasakaid.kasakaidboot.domain.artist.Artist;
import com.kasakaid.kasakaidboot.utility.LocalDateTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder(builderMethodName = "of")
@IdClass(FestivalArtistPrimaryKey.class)
@NoArgsConstructor
@AllArgsConstructor
public class FestivalArtist {

    @Id
    @Getter
    private long festivalId;
    @Id
    @Getter
    private long artistId;

    @Id
    @Getter
    private int playOrder;
    @Getter
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime start;

    @ManyToOne
    @JoinColumns({
            @JoinColumn( name = "festival_id")
    })
    private MusicFestival musicFestival;

    // 実質 1 対 1 になっておれば良いがリレーション上 1 対 多の関係になるので、OneToOne を使うと、
    // id 10 で複数行が見つかりました、と出てしまう。このため、OneToMany - ManyToOne 戦略を使う。
    @Getter
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}
