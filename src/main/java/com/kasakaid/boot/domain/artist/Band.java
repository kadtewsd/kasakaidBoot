package com.kasakaid.boot.domain.artist;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("band")
public class Band extends MusicGroup {
    public Band(long id, String name, int members, Genre genre) {
        super(id, name, members, genre);
    }
}
