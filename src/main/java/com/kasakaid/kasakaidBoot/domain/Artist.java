package com.kasakaid.kasakaidBoot.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder(builderMethodName = "of")
public class Artist implements Serializable {

    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String name;
}
