package com.fradou.nutrition.back.service.impl;

import com.fradou.nutrition.back.dto.PantryItemDto;
import com.fradou.nutrition.back.mapper.PantryItemMapper;
import com.fradou.nutrition.back.repository.PantryItemRepository;
import com.fradou.nutrition.back.service.PantryItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PantryItemServiceImpl implements PantryItemService {

    private PantryItemRepository repository;

    private PantryItemMapper mapper;

    @Override
    public List<PantryItemDto> getAllPantryItems() {
        return this.mapper.toDtoList(repository.findAll());
    }

    @Override
    public PantryItemDto createPantryItem(PantryItemDto dto) {
        return this.mapper.toDto(this.repository.save(mapper.toPojo(dto)));
    }
}
