package com.kasakaid.kasakaidBoot.domain.artist;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Builder(builderMethodName = "of")
public class Pop extends Artist {
}
