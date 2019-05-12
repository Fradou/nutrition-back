package com.fradou.nutrition.back.dto;

import com.fradou.nutrition.back.constant.FoodType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "DTO for Food")
public class FoodDto {

    @ApiModelProperty(value = "Id")
    private Integer id;

    @ApiModelProperty(value = "Label or name")
    private String label;

    @ApiModelProperty(value = "Protein amount in 100g" )
    private double protein;

    @ApiModelProperty(value = "Carb amount in 100g" )
    private double carbohydrate;

    @ApiModelProperty(value = "Fat amount in 100g" )
    private double fat;

    @ApiModelProperty(value = "Total calories for 100g" )
    private double calorie;

    @ApiModelProperty(value = "Type of food")
    private FoodType foodType;
}
