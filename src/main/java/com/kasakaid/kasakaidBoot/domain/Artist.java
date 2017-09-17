package com.kasakaid.kasakaidBoot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder(builderMethodName = "of")
public class Artist implements Serializable {

    @Id
    @Getter
    private long id;

    @Getter
    private String name;

    @OneToOne(mappedBy = "artist")
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private FestivalArtist festivalArtist;
}
