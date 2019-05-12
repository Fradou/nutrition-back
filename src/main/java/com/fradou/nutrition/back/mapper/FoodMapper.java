package com.fradou.nutrition.back.mapper;

import com.fradou.nutrition.back.dto.FoodDto;
import com.fradou.nutrition.back.entity.Food;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    FoodDto toDto(Food food);

    List<FoodDto> toDtoList(List<Food> foodList);

    Food toPojo(FoodDto foodDto);

    List<Food> toPojoList(List<FoodDto> foodDtoList);
}
