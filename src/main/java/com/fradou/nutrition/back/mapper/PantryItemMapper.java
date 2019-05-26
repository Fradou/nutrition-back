package com.fradou.nutrition.back.mapper;

import com.fradou.nutrition.back.dto.PantryItemDto;
import com.fradou.nutrition.back.entity.PantryItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FoodMapper.class})
public interface PantryItemMapper {

    PantryItemDto toDto(PantryItem pantryItem);

    List<PantryItemDto> toDtoList(List<PantryItem> pantryItemList);

    PantryItem toPojo(PantryItemDto PantryItemDto);

    List<PantryItem> toPojoList(List<PantryItemDto> pantryItemDtoList);
}
