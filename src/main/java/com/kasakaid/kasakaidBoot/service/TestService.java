package com.kasakaid.kasakaidBoot.service;

import com.kasakaid.kasakaidBoot.domain.TestTable;
import com.kasakaid.kasakaidBoot.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public List<TestTable> findAll() {
        return testRepository.findAll();
    }
}
