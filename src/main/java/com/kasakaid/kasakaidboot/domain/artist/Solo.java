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

    public Solo(long id, String name, Sex sex, Genre genre) {
        super(id, name, 1, genre);
        this.sex = sex;
    }

    @Override
    public Artist transform() {
        return new Solo(id, name, sex, genre);
    }
}
