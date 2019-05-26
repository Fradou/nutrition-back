package com.fradou.nutrition.back.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "DTO for Pantry Item")
public class PantryItemDto {

    @ApiModelProperty(value = "Id")
    private Integer id;

    @ApiModelProperty(value = "Expiration date")
    private LocalDate expirationDate;

    @ApiModelProperty(value = "FoodDto")
    private FoodDto foodDto;

    @ApiModelProperty(value = "Weight for given item")
    private Integer weight;

    @ApiModelProperty(value = "Number of shares for given item")
    private Integer share;
}
