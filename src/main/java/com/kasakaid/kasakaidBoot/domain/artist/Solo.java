package com.kasakaid.kasakaidBoot.domain.artist;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@NoArgsConstructor
public class Solo extends Artist {

    @Enumerated(EnumType.STRING)
    private Sex sex;
    public Solo (long id, String name, Sex sex) {
        super(id, name);
        this.sex = sex;
    }

}
