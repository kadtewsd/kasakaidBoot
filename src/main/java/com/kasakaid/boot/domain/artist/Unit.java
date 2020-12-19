package com.kasakaid.boot.domain.artist;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("unit")
public class Unit extends MusicGroup {
    public Unit(long id, String name, int members, Genre genre) {
        super(id, name, members, genre);
    }
}
