package com.kasakaid.kasakaidBoot.repository;

import com.kasakaid.kasakaidBoot.domain.MusicFestival;
import com.kasakaid.kasakaidBoot.domain.artist.Artist;
import com.kasakaid.kasakaidBoot.domain.artist.Group;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


// Criteria API を使い、条件がネストされているオブジェクトに向かうような場合は、組み立てを実施する必要あり。さもなくば、そんなプロパティがないと怒られる。
//Caused by: org.springframework.data.mapping.PropertyReferenceException: No property members found for type MusicFestival!
//public interface MusicFestivalMemberRepository extends JpaRepository<MusicFestival, Long>, JpaSpecificationExecutor<Group> {
public interface MusicFestivalMemberRepository  {
//    List<MusicFestival> findByMembers(Specifications specifications);
    <T extends Artist> List<T> findByMembers(Specifications<T> specifications);
}