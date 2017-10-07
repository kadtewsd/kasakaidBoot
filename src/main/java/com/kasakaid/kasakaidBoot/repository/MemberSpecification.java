package com.kasakaid.kasakaidBoot.repository;

import com.kasakaid.kasakaidBoot.domain.artist.Group;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class MemberSpecification {
    public static Specification<Group> members(Map<Integer, Integer> lowerUpper) {
        return (root, query, cb) -> {
            final Collection<Predicate> predicates = new ArrayList<>();
            lowerUpper.forEach((lower, upper) -> {
////                if (root.get("members") != null) {
                    predicates.add(
                            cb.and(cb.greaterThanOrEqualTo(root.get("members"), lower),
                                    cb.lessThanOrEqualTo(root.get("members"), upper))
                    );

////                }
//
            });
            return cb.or(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}