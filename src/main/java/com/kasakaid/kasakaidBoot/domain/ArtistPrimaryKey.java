package com.kasakaid.kasakaidBoot.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class ArtistPrimaryKey {

    private long festivalId;
    private long artistId;
}
