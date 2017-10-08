package com.kasakaid.kasakaidboot.domain.artist;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("unit")
public class Unit extends Group {
    public Unit(long id, String name, int members) {
        super(id, name, members);
    }
}
