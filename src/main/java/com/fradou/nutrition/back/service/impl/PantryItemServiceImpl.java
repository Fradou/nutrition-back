package com.fradou.nutrition.back.service.impl;

import com.fradou.nutrition.back.dto.PantryItemDto;
import com.fradou.nutrition.back.mapper.PantryItemMapper;
import com.fradou.nutrition.back.repository.PantryItemRepository;
import com.fradou.nutrition.back.repository.specification.PantryItemPredicateBuilder;
import com.fradou.nutrition.back.service.PantryItemService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PantryItemServiceImpl implements PantryItemService {

    private PantryItemRepository repository;

    private PantryItemMapper mapper;

    @Override
    public Page<PantryItemDto> getAll(String food, Pageable page) {
        return repository.findAll(PantryItemPredicateBuilder.foodNameLike(food), page).map(mapper::toDto);
    }

    @Override
    public PantryItemDto createOrUpdate(PantryItemDto dto) {
        return this.mapper.toDto(this.repository.save(mapper.toPojo(dto)));
    }

    @Override
    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
