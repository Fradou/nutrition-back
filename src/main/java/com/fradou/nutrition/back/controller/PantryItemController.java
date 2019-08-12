package com.fradou.nutrition.back.controller;

import com.fradou.nutrition.back.dto.PantryItemDto;
import com.fradou.nutrition.back.service.PantryItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pantryItems")
@AllArgsConstructor
@Api(value = "/pantryItems", description = "Controller for pantry items operation")
@CrossOrigin("*")
public class PantryItemController {

    private final List<String> ALLOWED_ORDER = Arrays.asList("expirationDate", "food");

    private PantryItemService pantryItemService;

    @GetMapping
    @ApiOperation(value = "Get list of pantry items, base on params")
    public Page<PantryItemDto> getPantryItems(
            @RequestParam(required = false) String food,
            @RequestParam(defaultValue = "20", required = false) Integer size,
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "expirationDate", required = false) String orderBy,
            @RequestParam(defaultValue = "ASC", required = false) String orderDir

    ) {
        if (!ALLOWED_ORDER.contains(orderBy)) {
            throw new RuntimeException("Ordre non autorisé");
        }
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(orderDir), orderBy);
        return pantryItemService.getAll(food, pageable);
    }

    @PostMapping
    @ApiOperation(value = "Create new pantryItem")
    public PantryItemDto createPantryItem(@RequestBody @Valid PantryItemDto dto) {
        return pantryItemService.createOrUpdate(dto);
    }

    @PutMapping
    @ApiOperation(value = "Update pantryItem")
    public PantryItemDto updatePantryItem(@RequestBody @Valid PantryItemDto dto) {
        return pantryItemService.createOrUpdate(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete pantryItem")
    public void deletePantryItem(@PathVariable Integer id) {
        pantryItemService.delete(id);
    }
}
