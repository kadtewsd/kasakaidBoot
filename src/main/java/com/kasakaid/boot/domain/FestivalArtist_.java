package com.kasakaid.boot.domain;

import com.kasakaid.boot.domain.artist.MusicGroup;

import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.StaticMetamodel;

// メタモデルはエンティティと同じパッケージに入れないと、NullPointerになる。
@StaticMetamodel(FestivalArtist.class)
public class FestivalArtist_ {

    public static volatile CollectionAttribute<FestivalArtist, MusicGroup> group;

}
