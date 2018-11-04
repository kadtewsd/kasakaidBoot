package com.kasakaid.kasakaidboot.repository;

import com.kasakaid.kasakaidboot.domain.artist.MusicGroup;
import com.kasakaid.kasakaidboot.domain.artist.Group_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MemberSpecification {
    public static Specification<MusicGroup> members(Map<Integer, Integer> lowerUpper) {
        return (root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            lowerUpper.forEach((lower, upper) -> {
                predicates.add(
                        cb.and(cb.between(root.get("members"), lower, upper))
                );

            });
            return cb.or(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    public static Specification<MusicGroup> membersByMetamodel(Map<Integer, Integer> lowerUpper) {
        return (root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            lowerUpper.forEach((lower, upper) -> {
                predicates.add(
                        cb.and(cb.greaterThanOrEqualTo(root.get(Group_.members), lower),
                                cb.lessThanOrEqualTo(root.get(Group_.members), upper))
                );

            });
            return cb.or(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
