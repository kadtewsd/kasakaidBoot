package com.kasakaid.kasakaidboot.domain.artist;

import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

/***** MappedsuperClass にしちゃうよ! *************
 // abstract にしないと、取得されるインスタンスの肩は MusicGroup になる。
 // abstract にすると find の時にインスタンス化できない
 このため、Entity ではなくて、Mappedsuperclass にする。
 これで、abstract にすることができるので、サブクラスの
 DiscriminatorValue が有効になる
 ----> と思ったら、全然ダメ。Joined にすると Single Table で
 できたことができないらしい。
 / ***********************************************/
@MappedSuperclass
@NoArgsConstructor
abstract class MappedArtist extends Artist  {
    MappedArtist(long id, String name, int members) {
        super(id, name, members);
    }
}
