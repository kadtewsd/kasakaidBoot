package com.kasakaid.kasakaidBoot.repository;

import com.kasakaid.kasakaidBoot.domain.TestTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestTable, Integer> {
    List<TestTable> findAll();
}
