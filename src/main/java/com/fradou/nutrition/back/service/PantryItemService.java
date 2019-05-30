package com.fradou.nutrition.back.service;

import com.fradou.nutrition.back.dto.PantryItemDto;

import java.util.List;

public interface PantryItemService {

    List<PantryItemDto> getAllPantryItems();

    PantryItemDto createPantryItem(PantryItemDto dto);
}
