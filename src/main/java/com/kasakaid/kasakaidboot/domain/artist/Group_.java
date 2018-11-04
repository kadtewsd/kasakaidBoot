package com.kasakaid.kasakaidboot.domain.artist;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MusicGroup.class)
public class Group_ {
    public static volatile SingularAttribute<MusicGroup, Integer> members;
}
