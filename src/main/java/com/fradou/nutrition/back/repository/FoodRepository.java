package com.fradou.nutrition.back.repository;

import com.fradou.nutrition.back.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer>, QuerydslPredicateExecutor<Food> {
}
