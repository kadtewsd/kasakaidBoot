package com.kasakaid.kasakaidBoot.repository;

import com.kasakaid.kasakaidBoot.domain.FestivalArtist;
import com.kasakaid.kasakaidBoot.domain.MusicFestival;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import java.security.acl.Group;
import java.util.Map;

public class MemberSpecificationWithSelect {
    public static Specification<Group> members(Map<Integer, Integer> lowerUpper) {
        return (root, query, cb) -> {
            final Subquery festivalQuery = query.subquery(Long.class);
            final Root<MusicFestival> musicFestivalRoot = festivalQuery.from(MusicFestival.class);
            final Join<MusicFestival, FestivalArtist> festivalArtistJoin = musicFestivalRoot.join("artists");
            festivalQuery.select(festivalArtistJoin.get("festival_id"));
            Predicate predicate = cb.conjunction();
            lowerUpper.forEach((lower, upper) -> {
                if (root.get("members") != null) {
                    cb.or(predicate, cb.between(root.get("members"), lower, upper));
                }

            });
            festivalQuery.where(predicate);
            return cb.in(musicFestivalRoot.get("id")).value(predicate);
        };
    }
}
