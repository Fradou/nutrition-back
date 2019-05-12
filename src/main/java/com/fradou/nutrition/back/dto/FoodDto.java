package com.fradou.nutrition.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {

    private Integer id;

    private String label;

    private double protein;

    private double carbohydrate;

    private double fat;

    private double calorie;
}
