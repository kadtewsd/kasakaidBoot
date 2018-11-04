package com.kasakaid.kasakaidboot.domain.artist;

import lombok.Getter;

import java.util.function.Function;

public enum GroupType {
    BAND("BAND", (g -> new Band(g.getId(), g.getName(), g.getMembers()))),
    UNIT("UNIT", (g -> new Unit(g.getId(), g.getName(), g.getMembers())));
    GroupType(String dtype, Function<MusicGroup, MusicGroup> transform) {
        this.dtype = dtype;
        this.transform = transform;
    }

    private String dtype;
    @Getter
    private Function<MusicGroup, MusicGroup> transform;
}
