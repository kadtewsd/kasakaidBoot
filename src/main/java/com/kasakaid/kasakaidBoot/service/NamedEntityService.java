package com.kasakaid.kasakaidBoot.service;

import com.kasakaid.kasakaidBoot.domain.TestTable;
import com.kasakaid.kasakaidBoot.repository.NamedEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NamedEntityService {
    @Autowired
    private NamedEntityRepository namedEntityRepository;

    public List<TestTable> findAll() {
        return namedEntityRepository.findAll();
    }
    public List<TestTable> findAll(List<Integer> id) {
        return namedEntityRepository.findAll(id);
    }
    public List<TestTable> findOne(int id) {
        return namedEntityRepository.findOne(id);
    }
}
