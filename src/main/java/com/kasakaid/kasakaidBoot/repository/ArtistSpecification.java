package com.kasakaid.kasakaidBoot.repository;

import com.kasakaid.kasakaidBoot.domain.artist.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArtistSpecification {
    public static Specification artistMembers(Map<Integer, Integer> lowerUpper) {
        return (root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            lowerUpper.forEach((lower, upper) -> {
                predicates.add(
                        cb.and(cb.between(root.get(Group_.members), lower, upper))
                );

            });
            Predicate group = cb.or(predicates.toArray(new Predicate[predicates.size()]));
            Predicate solo = root.get(Solo_.sex).in(Sex.Female, Sex.Male);
            return cb.or(group, solo);
        };
    }
    public static Specification artistWithId(Map<Integer, Integer> lowerUpper) {
        return (root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            lowerUpper.forEach((lower, upper) -> {
                predicates.add(
                        cb.and(cb.greaterThanOrEqualTo(root.get(Group_.members), lower),
                                cb.lessThanOrEqualTo(root.get(Group_.members), upper))
                );

            });
            Predicate group = cb.or(predicates.toArray(new Predicate[predicates.size()]));
            Predicate solo = cb.isNull(root.get(Group_.members));
            return cb.or(group, solo);
        };
    }
}
