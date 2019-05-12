package com.fradou.nutrition.back.controller;

import com.fradou.nutrition.back.dto.FoodDto;
import com.fradou.nutrition.back.service.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foods")
@AllArgsConstructor
@Api(value = "/foods", description = "Controller for foods operation")
public class FoodController {

    private FoodService foodService;

    @GetMapping
    @ApiOperation(value = "Get list of all foods")
    @CrossOrigin("*")
    public List<FoodDto> getAllFoods() {
        return foodService.getAllFoods();
    }
}
