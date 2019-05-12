package com.fradou.nutrition.back.service;

import com.fradou.nutrition.back.dto.FoodDto;

import java.util.List;

public interface FoodService {
    List<FoodDto> getAllFoods();

    FoodDto getFoodById(Integer foodId);

    FoodDto update(Integer idFood, FoodDto foodDto) throws Exception;

    FoodDto createFood(FoodDto foodDto);
}
