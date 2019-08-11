package com.fradou.nutrition.back.service;

import com.fradou.nutrition.back.dto.PantryItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PantryItemService {

    Page<PantryItemDto> getAll(String food, Pageable pageable);

    PantryItemDto createOrUpdate(PantryItemDto dto);

    void delete(Integer id);
}
