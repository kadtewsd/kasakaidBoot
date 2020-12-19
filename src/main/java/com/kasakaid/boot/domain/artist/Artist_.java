package com.kasakaid.boot.domain.artist;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Artist.class)
public class Artist_ {
    public static volatile SingularAttribute<MusicGroup, Integer> members;
}
