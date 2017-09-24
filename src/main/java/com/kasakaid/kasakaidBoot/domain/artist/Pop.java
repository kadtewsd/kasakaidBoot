package com.kasakaid.kasakaidBoot.domain.artist;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Builder(builderMethodName = "of")
@NoArgsConstructor
public class Pop extends Artist {
}
