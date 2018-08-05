package com.kasakaid.kasakaidboot.domain.artist;

import lombok.Getter;

import java.util.function.Function;

public enum GroupType {
    BAND("band", (g -> new Band(g.getId(), g.getName(), g.getMembers()))),
    UNIT("unit", (g -> new Unit(g.getId(), g.getName(), g.getMembers())));
    GroupType(String dtype, Function<Group, Group> transform) {
        this.dtype = dtype;
        this.transform = transform;
    }

    private String dtype;
    @Getter
    private Function<Group,  Group> transform;
}
