package com.kasakaid.kasakaidBoot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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

    @Getter
    private long playOrder;
    @Getter
    private Date start;

    @ManyToOne
    @JoinColumns({
            @JoinColumn( name = "festival_id"),
    })
    private MusicFestival musicFestival;

    @OneToOne(fetch = FetchType.EAGER)
    @Getter
    private Artist artist;
}
