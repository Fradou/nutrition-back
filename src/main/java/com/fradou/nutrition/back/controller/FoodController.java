package com.fradou.nutrition.back.controller;

import com.fradou.nutrition.back.dto.FoodDto;
import com.fradou.nutrition.back.service.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/foods")
@AllArgsConstructor
@Api(value = "/foods", description = "Controller for foods operation")
@CrossOrigin("*")
public class FoodController {

    private FoodService foodService;

    @GetMapping
    @ApiOperation(value = "Get list of all foods")
    public Page<FoodDto> getAllFoods(
            @RequestParam(defaultValue = "20") Integer size,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) String search
    ) {
        return foodService.getAllFoods(search, PageRequest.of(page, size));
    }

    @GetMapping(value = "/{idFood}")
    @ApiOperation(value = "Return food with given id")
    public FoodDto getFoodById(@PathVariable Integer idFood) {
        return foodService.getFoodById(idFood);
    }

    @PutMapping(value = "/{idFood}")
    @ApiOperation(value = "Update food with given id")
    public FoodDto updateFood(@PathVariable Integer idFood, @RequestBody FoodDto foodDto) throws Exception {
        return foodService.update(idFood, foodDto);
    }

    @PostMapping
    @ApiOperation(value = "Create new food")
    public FoodDto createFood(@RequestBody @Valid FoodDto foodDto, BindingResult result) throws Exception {
        if(result.hasErrors()) throw new Exception("Invalid");
        return foodService.createFood(foodDto);
    }
}
