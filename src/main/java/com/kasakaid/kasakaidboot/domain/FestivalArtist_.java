package com.kasakaid.kasakaidboot.domain;

import com.kasakaid.kasakaidboot.domain.artist.Group;

import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.StaticMetamodel;

// メタモデルはエンティティと同じパッケージに入れないと、NullPointerになる。
@StaticMetamodel(FestivalArtist.class)
public class FestivalArtist_ {

    public static volatile CollectionAttribute<FestivalArtist, Group> group;

}
