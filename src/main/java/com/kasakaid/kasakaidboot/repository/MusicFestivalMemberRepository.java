package com.kasakaid.kasakaidboot.repository;

import com.kasakaid.kasakaidboot.domain.artist.Artist;
import org.springframework.data.jpa.domain.Specifications;

import java.util.List;


// Criteria API を使い、条件がネストされているオブジェクトに向かうような場合は、組み立てを実施する必要あり。さもなくば、そんなプロパティがないと怒られる。
//Caused by: org.springframework.data.mapping.PropertyReferenceException: No property members found for type MusicFestival!
//public interface MusicFestivalMemberRepository extends JpaRepository<MusicFestival, Long>, JpaSpecificationExecutor<Group> {
public interface MusicFestivalMemberRepository  {
//    List<MusicFestival> findByMembers(Specifications specifications);
    <T extends Artist> List<T> findByMembers(Specifications<T> specifications);
}