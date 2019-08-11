package com.fradou.nutrition.back.repository.specification;

import com.fradou.nutrition.back.entity.Food;
import org.springframework.data.jpa.domain.Specification;

public class FoodSpecification {

    public static Specification<Food> bySearchTerm(String searchTerm) {
        return null;
    }
}
