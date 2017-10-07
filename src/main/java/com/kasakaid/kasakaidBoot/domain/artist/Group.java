package com.kasakaid.kasakaidBoot.domain.artist;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
class Group extends Artist {

    Group(long id, String name, int members) {
        super(id, name);
        this.members = members;
    }
    @Getter
    private int members;
}
