package com.fradou.nutrition.back.service.impl;

import com.fradou.nutrition.back.dto.FoodDto;
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

    public List<FoodDto> getAllFoods() {
        return foodMapper.toDtoList(foodRepository.findAll());
    }
}
