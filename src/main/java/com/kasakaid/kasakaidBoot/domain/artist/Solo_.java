package com.kasakaid.kasakaidBoot.domain.artist;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Solo.class)
public class Solo_ {

    // String にすることで Enum を指定すると、String で検索してくれる。
    public static volatile SingularAttribute<Solo, String> sex;
}
