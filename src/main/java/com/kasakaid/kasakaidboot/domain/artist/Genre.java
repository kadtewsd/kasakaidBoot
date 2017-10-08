package com.kasakaid.kasakaidboot.domain.artist;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Entity
@Embeddable
public class Genre {

    @Id
    private int id;
    private String name;
    private String note;

    @OneToMany(mappedBy = "genre")
    private List<Artist> artists;
}
