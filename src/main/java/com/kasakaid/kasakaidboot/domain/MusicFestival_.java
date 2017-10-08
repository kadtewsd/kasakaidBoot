package com.kasakaid.kasakaidboot.domain;

import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MusicFestival.class)
public class MusicFestival_ {

    public static volatile CollectionAttribute<MusicFestival, FestivalArtist> applications;
}
