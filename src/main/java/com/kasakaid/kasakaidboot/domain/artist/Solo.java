package com.kasakaid.kasakaidboot.domain.artist;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@NoArgsConstructor
@Getter
public class Solo extends Artist {

    @Enumerated(EnumType.STRING)
    private Sex sex;
    public Solo (long id, String name, Sex sex) {
        super(id, name);
        this.sex = sex;
    }

}