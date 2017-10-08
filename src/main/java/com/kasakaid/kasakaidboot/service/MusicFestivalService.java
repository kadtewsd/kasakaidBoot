package com.kasakaid.kasakaidboot.service;

import com.kasakaid.kasakaidboot.domain.MusicFestival;
import com.kasakaid.kasakaidboot.repository.MusicFestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MusicFestivalService {

    private final MusicFestivalRepository musicFestivalRepository;

    public List<MusicFestival> findAll() {
        return musicFestivalRepository.findAll();
    }

    public MusicFestival findOne(Long id) {
        return musicFestivalRepository.findById(id);
    }

    public List<MusicFestival> findByMembers(Map<Integer, Integer> members) {
        return musicFestivalRepository.findAll();
    }
}
