package com.kasakaid.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/***
 * 結合については下記を参照。
 * https://en.wikibooks.org/wiki/Java_Persistence/ElementCollection
 * The limitations of using an ElementCollection instead of a OneToMany is that the target objects cannot be queried,
 * persisted, merged independently of their parent object.
 * They are strictly privately-owned (dependent) objects, the same as an Embedded mapping.
 * There is no cascade option on an ElementCollection, the target objects are always persisted, merged, removed with their parent.
 * ElementCollection still can use a fetch type and defaults to LAZY the same as other collection mappings.
 */
@Entity
@AllArgsConstructor
@NamedEntityGraph(
        name = "music.festival",
        attributeNodes = @NamedAttributeNode(value = "artists", subgraph = "artist"),
        subclassSubgraphs = {
                @NamedSubgraph(name = "artist",
                        attributeNodes = {
                                @NamedAttributeNode("name")
                        })
        }
)
@Builder(builderMethodName = "of")
public class MusicFestival {
    @Id
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String place;

    //    @Access(AccessType.PROPERTY)
//    private LocalDate eventDate;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date eventDate;

    public LocalDate getEventDate() {
        return LocalDate.now();
    }

//    @Convert(converter = LocalDateConverter.class)
    private void setEventDate(Date eventDate) {
//        this.eventDate = eventDate.atTime()
        System.out.println("とおた");
    }

    public MusicFestival eventDate(LocalDate _eventDate) {
//        this.setEventDate(_eventDate);
        return this;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "musicFestival")
    @Getter
    @OrderBy("playOrder ASC")
    private List<FestivalArtist> artists;

    private void setArtists(List<FestivalArtist> artists) {
        this.artists = artists;
    }

    public boolean storeArtistsList(List<FestivalArtist> artists) {
        setArtists(artists);
        return true;
    }


    public MusicFestival() {
        System.out.print(1);
    }
}
