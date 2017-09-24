package com.kasakaid.kasakaidBoot.domain.artist;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Builder
@NoArgsConstructor // コンストラクタを作ったので、引数なしのコンストラクタを明示しないといけない
public class Rock extends Artist {
    // 継承する場合はこんな実装が必要。
    @Builder(builderMethodName = "of")
    public Rock(long id, String name, int members) {
        super(id, name, members);
    }
}
