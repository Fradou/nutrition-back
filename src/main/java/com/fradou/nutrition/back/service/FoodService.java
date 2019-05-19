package com.fradou.nutrition.back.service;

import com.fradou.nutrition.back.dto.FoodDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface FoodService {
    Page<FoodDto> getAllFoods(String search, PageRequest of);

    FoodDto getFoodById(Integer foodId);

    FoodDto update(Integer idFood, FoodDto foodDto) throws Exception;

    FoodDto createFood(FoodDto foodDto);
}
