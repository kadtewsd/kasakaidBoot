package com.kasakaid.kasakaidBoot.domain.artist;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name ="group_artist")
//@DiscriminatorColumn(name = "dtype")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// abstract にすると find するときにインスタンス化できない。が気がない。
public class Group extends Artist {

    Group(long id, String name, int members) {
        super(id, name);
        this.members = members;
    }
    @Getter
    private int members;

    // 実エンティティを継承した場合、dtype をddl-auto でデフォルトで作らないらしい。仕方がないので、フィールドを用意する。
    private String dtype;
}
