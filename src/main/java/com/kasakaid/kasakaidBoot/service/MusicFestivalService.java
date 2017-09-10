package com.kasakaid.kasakaidBoot.service;

import com.kasakaid.kasakaidBoot.domain.MusicFestival;
import com.kasakaid.kasakaidBoot.repository.MusicFestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicFestivalService {
    @Autowired
    private MusicFestivalRepository musicFestivalRepository;

    public List<MusicFestival> findAll() {
        return musicFestivalRepository.findAll();
    }

    public MusicFestival findOne(Long id) {
        return musicFestivalRepository.findById(id);
    }
}
