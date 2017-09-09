package com.kasakaid.kasakaidBoot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@NamedEntityGraph(
        name = "music.festival",
        attributeNodes = @NamedAttributeNode(value = "artists")
)
public class MusicFestival {
    @Id
    private Long id;
    private String name;
    private String place;
    @Temporal(TemporalType.DATE)
    private Date eventDate;

    @Embedded
    @CollectionTable( name="artist", joinColumns=@JoinColumn(name="festivalId"))
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "musicFestival")
    List<Artist> artists;
}
