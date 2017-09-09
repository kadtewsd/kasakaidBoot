package com.kasakaid.kasakaidBoot.repository;

import com.kasakaid.kasakaidBoot.domain.MusicFestival;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicFestivalRepository extends JpaRepository<MusicFestival, Long> {

    @Query("select distinct x from MusicFestival x left outer join fetch x.artists")
    List<MusicFestival> findAll();

    @EntityGraph(value = "music.festival" , type= EntityGraph.EntityGraphType.FETCH)
    @Query("select distinct x from MusicFestival x where id=?1")
    List<MusicFestival> findById(Long id);
}
