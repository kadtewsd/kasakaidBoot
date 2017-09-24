package com.kasakaid.kasakaidBoot.domain.artist;

import com.kasakaid.kasakaidBoot.domain.FestivalArtist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Artist implements Serializable {

    public Artist (long id, String name, int members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }
    @Id
    @Getter
    private long id;

    @Getter
    private String name;

    @Getter
    private int members;
    @OneToOne(mappedBy = "artist")
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    protected FestivalArtist festivalArtist;
}
