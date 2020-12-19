package com.kasakaid.boot.repository;

import com.kasakaid.boot.domain.artist.Artist;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


// Criteria API を使い、条件がネストされているオブジェクトに向かうような場合は、組み立てを実施する必要あり。さもなくば、そんなプロパティがないと怒られる。
//Caused by: org.springframework.data.mapping.PropertyReferenceException: No property members found for type MusicFestival!
//public interface MusicFestivalMemberRepository extends JpaRepository<MusicFestival, Long>, JpaSpecificationExecutor<MusicGroup> {
public interface MusicFestivalMemberRepository  {
//    List<MusicFestival> findByMembers(Specifications specifications);
    <T extends Artist> List<T> findByMembers(Specification<T> specifications);
}