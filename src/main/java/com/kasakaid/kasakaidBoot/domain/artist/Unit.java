package com.kasakaid.kasakaidBoot.domain.artist;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Unit extends Group {
    public Unit(long id, String name, int members) {
        super(id, name, members);
    }
}
