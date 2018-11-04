package com.kasakaid.kasakaidboot.repository;

import com.kasakaid.kasakaidboot.domain.artist.MusicGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroupRepository extends JpaRepository<MusicGroup, Long>, JpaSpecificationExecutor<MusicGroup> {
}
