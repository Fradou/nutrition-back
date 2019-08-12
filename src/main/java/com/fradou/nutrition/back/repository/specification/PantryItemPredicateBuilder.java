package com.fradou.nutrition.back.repository.specification;

import com.fradou.nutrition.back.entity.QPantryItem;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;

public class PantryItemPredicateBuilder {

    private static final QPantryItem pantryItem = QPantryItem.pantryItem;

    public static Predicate foodNameLike(String foodName) {
        return foodName != null ?
                pantryItem.food.label.likeIgnoreCase(Expressions.asString("%").concat(foodName).concat("%"))
                : null;
    }
}
