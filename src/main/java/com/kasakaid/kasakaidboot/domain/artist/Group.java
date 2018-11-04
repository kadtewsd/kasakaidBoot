package com.kasakaid.kasakaidboot.domain.artist;

import com.kasakaid.kasakaidboot.domain.service.ArtistTransformer;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/***** MappedsuperClass を継承した! *************
 // abstract にしないと、取得されるインスタンスの肩は Group になる。
 // abstract にすると find の時にインスタンス化できない
 このため、Entity ではなくて、Mappedsuperclass にするが全然ダメ。
 Joined にすると Single Table でできたことができないらしい。
***********************************************/
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Entity
public abstract class Group extends MappedArtist implements ArtistTransformer {

    Group(long id, String name, int members) {
        super(id, name, members);
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    // 実エンティティを継承した場合、dtype をddl-auto でデフォルトで作らないらしい。仕方がないので、フィールドを用意する。
    private GroupType dtype;

    @Override
    public Artist transform() {
        if (this.dtype == null) return this;
        return this.dtype.getTransform().apply(this);
    }
}
