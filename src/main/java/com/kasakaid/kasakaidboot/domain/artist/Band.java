package com.kasakaid.kasakaidboot.domain.artist;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@DiscriminatorValue("band")
public class Band extends Group {
    public Band(long id, String name, int members) {
        super(id, name, members);
    }
}
