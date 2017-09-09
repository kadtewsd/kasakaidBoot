package com.kasakaid.kasakaidBoot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

//    @Embedded
    // element コレクションがないと artists は取ってこない。
//    @ElementCollection(fetch = FetchType.EAGER)
    // ElementCollection ありの状態で Collection テーブルを指定すると、
    // Caused by: org.hibernate.tool.schema.spi.SchemaManagementException: Schema-validation: missing column [artists_festival_id] in table [artist]
//    @CollectionTable( name="artist", joinColumns=@JoinColumn(name="festivalId"))
//    @JoinTable(name = "artist", inverseJoinColumns = @JoinColumn(name = "id"))
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "musicFestival")
    private List<Artist> artists;
}
