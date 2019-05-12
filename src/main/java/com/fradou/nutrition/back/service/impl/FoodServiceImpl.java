package com.fradou.nutrition.back.service.impl;

import com.fradou.nutrition.back.dto.FoodDto;
import com.fradou.nutrition.back.entity.Food;
import com.fradou.nutrition.back.exception.ResourceNotFoundException;
import com.fradou.nutrition.back.mapper.FoodMapper;
import com.fradou.nutrition.back.repository.FoodRepository;
import com.fradou.nutrition.back.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRepository;

    private FoodMapper foodMapper;

    @Override
    public List<FoodDto> getAllFoods() {
        return foodMapper.toDtoList(foodRepository.findAll());
    }

    @Override
    public FoodDto getFoodById(Integer foodId) {
        return foodMapper.toDto(foodRepository.findById(foodId).orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public FoodDto update(Integer idFood, FoodDto foodDto) throws Exception {
        if(!idFood.equals(foodDto.getId())) throw new Exception("Bad request");
        Food food = foodMapper.toPojo(foodDto);
        return foodMapper.toDto(foodRepository.save(food));
    }

    @Override
    public FoodDto createFood(FoodDto foodDto) {
        Food food = foodMapper.toPojo(foodDto);
        return foodMapper.toDto(foodRepository.save(food));
    }
}
