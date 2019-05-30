package com.fradou.nutrition.back.mapper;

import com.fradou.nutrition.back.dto.PantryItemDto;
import com.fradou.nutrition.back.entity.PantryItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FoodMapper.class})
public interface PantryItemMapper {

    @Mapping(source = "food", target = "foodDto")
    PantryItemDto toDto(PantryItem pantryItem);

    List<PantryItemDto> toDtoList(List<PantryItem> pantryItemList);

    @Mapping(source = "foodDto", target = "food")
    PantryItem toPojo(PantryItemDto PantryItemDto);

    List<PantryItem> toPojoList(List<PantryItemDto> pantryItemDtoList);
}
