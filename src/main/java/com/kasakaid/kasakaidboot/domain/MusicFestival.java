package com.kasakaid.kasakaidboot.domain;

import com.kasakaid.kasakaidboot.utility.LocalDateConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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
@NoArgsConstructor
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

    @Getter
    @Convert(converter = LocalDateConverter.class)
    private LocalDate eventDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "musicFestival")
    @Getter
    @Setter
    @OrderBy("playOrder ASC")
    private List<FestivalArtist> artists;
}