package com.fradou.nutrition.back.controller;

import com.fradou.nutrition.back.dto.FoodDto;
import com.fradou.nutrition.back.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("foods")
@AllArgsConstructor
public class FoodController {

    FoodService foodService;

    @GetMapping
    List<FoodDto> getAllFoods() {
        return foodService.getAllFoods();
    }
}
