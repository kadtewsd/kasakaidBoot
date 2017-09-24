package com.kasakaid.kasakaidBoot.domain.artist;

import com.kasakaid.kasakaidBoot.domain.FestivalArtist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Artist implements Serializable {

    public Artist (long id, String name, int members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }
    @Id
    @Getter
    private long id;

    @Getter
    private String name;

    @Getter
    private int members;
    // 実質 1 対 1 になっておれば良いがリレーション上 1 対 多の関係になるので、OneToOne を使うと、
    // id 10 で複数行が見つかりました、と出てしまう。このため、OneToMany - ManyToOne 戦略を使う。
    @Getter
    @OneToMany(mappedBy = "artist")
    private List<FestivalArtist> festivalArtist;
}
