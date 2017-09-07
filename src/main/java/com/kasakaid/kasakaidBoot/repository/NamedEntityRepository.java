package com.kasakaid.kasakaidBoot.repository;

import com.kasakaid.kasakaidBoot.domain.TestTable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NamedEntityRepository extends JpaRepository<TestTable, Integer> {

    @EntityGraph(value = "test" , type= EntityGraph.EntityGraphType.FETCH)
    List<TestTable> findAll();

    @EntityGraph(value = "test" , type= EntityGraph.EntityGraphType.FETCH)
    List<TestTable> findOne(int userId);

//    @EntityGraph(value = "test" , type= EntityGraph.EntityGraphType.FETCH)
//    List<TestTable> findAll(List<Integer> userIds);
}
