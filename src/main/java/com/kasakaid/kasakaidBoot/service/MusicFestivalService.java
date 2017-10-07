package com.kasakaid.kasakaidBoot.service;

import com.kasakaid.kasakaidBoot.domain.MusicFestival;
import com.kasakaid.kasakaidBoot.repository.MusicFestivalMemberRepository;
import com.kasakaid.kasakaidBoot.repository.MusicFestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specifications;
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
