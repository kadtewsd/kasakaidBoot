package com.kasakaid.boot.repository;

import com.kasakaid.boot.domain.MusicFestival;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicFestivalRepository extends JpaRepository<MusicFestival, Long> {

    @Query("select distinct x from MusicFestival x left outer join fetch x.artists y left outer join fetch y.artist z order by y.playOrder")
    List<MusicFestival> findAll();

    @EntityGraph(value = "music.festival" , type= EntityGraph.EntityGraphType.FETCH, attributePaths = {"artists"})
    @Query("select distinct x from MusicFestival x where id=?1")
    Optional<MusicFestival> findById(Long id);
}
