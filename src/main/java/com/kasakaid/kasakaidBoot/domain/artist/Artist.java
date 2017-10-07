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
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
public abstract class Artist implements Serializable {

    Artist (long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Id
    private long id;

    private String name;

    // 実質 1 対 1 になっておれば良いがリレーション上 1 対 多の関係になるので、OneToOne を使うと、
    // id 10 で複数行が見つかりました、と出てしまう。このため、OneToMany - ManyToOne 戦略を使う。
    @OneToMany(mappedBy = "artist")
    private List<FestivalArtist> festivalArtist;

    @ManyToOne
    @JoinColumn(name = "genre")
    private Genre genre;
}
