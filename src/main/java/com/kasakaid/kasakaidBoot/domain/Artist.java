package com.kasakaid.kasakaidBoot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Embeddable
@Entity
@AllArgsConstructor
// このクラスは MusicFestival に参照されており、toString によって StackOverFlow になる。
// @ToString(Exclude="musicFestival") を書くより getter, setter を各プロパティにかく。
//@Data
public class Artist implements Serializable {

    @Getter
    @Setter
    @Id
    private long artistId;
    //@Column(name = "festival_id")
    // ManyToOne で 結合するカラム名は、論理名 (プロパティ名) が採用されるので、@Column で指定しないと
    // Caused by: org.hibernate.DuplicateMappingException: Table [artist] contains physical column name [festival_id] referred to by multiple physical column names: [festival_id], [festivalId]
    // ただし、この方式だと、親テーブルのプロパティに書く必要がある @JoinColumn で referenceColumn を書かなくて良い。
    @Id
    @Getter
    @Setter
    private long festivalId;
    @Getter
    @Setter
    private String name;
    //order にすると syntax エラー。
    // ARTISTS1_.ORDER[*] と SQL が発行される
    @Getter
    @Setter
    private long playOrder;
    @Getter
    @Setter
    private Date start;

    //@JoinColumn で name だけ指定すると、
    //Caused by: java.lang.TypeNotPresentException: Type com.kasakaid.kasakaidBoot.domain.Artist not present
    //at sun.reflect.generics.factory.CoreReflectionFactory.makeNamedType(CoreReflectionFactory.java:117)
    //at sun.reflect.generics.visitor.Reifier.visitClassTypeSignature(Reifier.java:125)
    //at sun.reflect.generics.tree.ClassTypeSignature.accept(ClassTypeSignature.java:49)
    //at sun.reflect.generics.visitor.Reifier.reifyTypeArguments(Reifier.java:68)
    //at sun.reflect.generics.visitor.Reifier.visitClassTypeSignature(Reifier.java:138)
    //at sun.reflect.generics.tree.ClassTypeSignature.accept(ClassTypeSignature.java:49)
    //at sun.reflect.generics.repository.MethodRepository.getReturnType(MethodRepository.java:68)
    //at java.lang.reflect.Method.getGenericReturnType(Method.java:255)
    @ManyToOne
    @JoinColumn(name = "festivalId", referencedColumnName = "id")
    private MusicFestival musicFestival;
}
