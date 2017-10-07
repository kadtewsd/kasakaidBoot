package com.kasakaid.kasakaidBoot.repository;

import com.kasakaid.kasakaidBoot.domain.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArtistRepository<T extends Artist>  extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
}
