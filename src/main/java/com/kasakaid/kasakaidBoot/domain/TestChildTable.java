package com.kasakaid.kasakaidBoot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class TestChildTable {

//    private int userId;
    private int userDetailId;
    private String userName;
}
