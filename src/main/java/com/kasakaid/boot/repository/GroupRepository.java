package com.kasakaid.boot.repository;

import com.kasakaid.boot.domain.artist.MusicGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroupRepository extends JpaRepository<MusicGroup, Long>, JpaSpecificationExecutor<MusicGroup> {
}
