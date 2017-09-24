package com.kasakaid.kasakaidBoot.domain.artist;

import lombok.Builder;

import javax.persistence.Entity;

@Entity
@Builder(builderMethodName = "of")
public class Punk extends Artist {
}
