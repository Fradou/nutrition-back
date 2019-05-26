package com.fradou.nutrition.back.service.impl;

import com.fradou.nutrition.back.entity.PantryItem;
import com.fradou.nutrition.back.repository.PantryItemRepository;
import com.fradou.nutrition.back.service.PantryItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PantryItemServiceImpl implements PantryItemService {

    private PantryItemRepository repository;

    @Override
    public List<PantryItem> getAllPantryItems() {
        return this.repository.findAll();
    }
}
