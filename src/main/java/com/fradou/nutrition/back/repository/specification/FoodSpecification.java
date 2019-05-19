package com.fradou.nutrition.back.repository.specification;

import com.fradou.nutrition.back.entity.Food;
import com.fradou.nutrition.back.entity.Food_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class FoodSpecification {

    public static Specification<Food> bySearchTerm(String searchTerm) {
        return (root, query, cb) -> StringUtils.hasText(searchTerm) ? cb.like(root.get(Food_.LABEL), "%" + searchTerm + "%") : null;
    }
}
