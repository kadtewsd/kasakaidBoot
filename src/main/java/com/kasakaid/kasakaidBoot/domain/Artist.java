package com.kasakaid.kasakaidBoot.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Embeddable
@Entity
public class Artist implements Serializable {

    @Id
    private long artistId;
    @Id
    private long festivalId;
    private String name;
    //order にすると syntax エラー。
    // ARTISTS1_.ORDER[*] と SQL が発行される
    private long playOrder;
    private Date start;

//    @ManyToOne
//    @JoinColumn(name = "festival_id")
//    private MusicFestival musicFestival;
}
