package com.kasakaid.kasakaidBoot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FestivalArtistPrimaryKey implements Serializable {

    @Column(name = "festival_id", insertable = false, updatable = false)
    private long festivalId;
    @Column(name = "artist_id", insertable = false, updatable = false)
    private long artistId;
}
