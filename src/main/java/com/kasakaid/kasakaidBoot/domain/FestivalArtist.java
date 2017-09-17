package com.kasakaid.kasakaidBoot.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder(builderMethodName = "of")
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FestivalArtist implements Serializable {

    @Getter
    private long artistId;
    @Getter
    @Column(name = "festival_id", insertable = false, updatable = false)
    private long festivalId;
    @Getter
    private long playOrder;

    @Getter
    private Date start;

    @Embedded
    @Transient // FestivalArtist は Entity ではないため、id がない。結合時には親テーブルに id が必要らしく、Artist との結合時に id がないと怒られる。
    @Setter
    @Getter
    @JoinColumn(name = "id", referencedColumnName = "artist_id")
    private Artist artist;

}
