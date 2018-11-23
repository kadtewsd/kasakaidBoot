package com.kasakaid.kasakaidboot.application;

import com.kasakaid.kasakaidboot.domain.FestivalArtist;
import com.kasakaid.kasakaidboot.domain.MusicFestival;
import com.kasakaid.kasakaidboot.domain.artist.Artist;
import com.kasakaid.kasakaidboot.domain.service.ArtistTransformer;
import com.kasakaid.kasakaidboot.repository.MusicFestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicFestivalService {

    private final MusicFestivalRepository musicFestivalRepository;

    public List<MusicFestival> findAll() {
        return this.transformArtist(
                musicFestivalRepository.findAll()
        );
    }

    public MusicFestival findOne(Long id) {
        return this.transformArtist(
                musicFestivalRepository.findById(id).get()
        );
    }

    public List<MusicFestival> findByMembers(Map<Integer, Integer> members) {
        return musicFestivalRepository.findAll()
                .stream()
                .filter(mf -> mf.storeArtistsList(mf.getArtists().stream()
                            .filter(a -> members.entrySet().stream()
                                    .anyMatch(m1 -> m1.getKey() <= a.getArtist().getMembers()
                                            && m1.getValue() >= a.getArtist().getMembers()
                                    )
                            )
                            .collect(Collectors.toList())
                    )
                )
                .collect(Collectors.toList());
    }

    private List<MusicFestival> transformArtist(List<MusicFestival> festivals) {
        festivals.forEach(this::transformArtist);
        return festivals;
    }

    private MusicFestival transformArtist(MusicFestival festival) {
        festival.storeArtistsList(
                festival.getArtists().stream().map((FestivalArtist festivalArtist) -> {
                    if (festivalArtist.getArtist() instanceof ArtistTransformer) {
                        festivalArtist.renewArtists((ArtistTransformer) festivalArtist.getArtist());
                    }
                    return festivalArtist;
                })
                        .collect(Collectors.toList())
        );
        return festival;
    }
}
