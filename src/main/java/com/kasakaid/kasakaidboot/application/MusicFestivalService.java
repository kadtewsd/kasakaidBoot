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
        List<MusicFestival> results = musicFestivalRepository.findAll();
        for (MusicFestival musicFestival : results) {
            for (int i = musicFestival.getArtists().size() - 1; i >= 0; i--) {
                Artist artist = musicFestival.getArtists().get(i).getArtist();
                boolean ok = false;
                for (Map.Entry<Integer, Integer> upperLower : members.entrySet()) {
                    if (upperLower.getKey() <= artist.getMembers() && artist.getMembers() <= upperLower.getValue()) {
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    musicFestival.getArtists().remove(i);
                }
            }
        }
        return results;
    }

    private List<MusicFestival> transformArtist(List<MusicFestival> festivals) {
        festivals.forEach(this::transformArtist);
        return festivals;
    }

    private MusicFestival transformArtist(MusicFestival festival) {
        festival.setArtists(
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
