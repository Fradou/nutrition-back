package com.fradou.nutrition.back.controller;

import com.fradou.nutrition.back.entity.PantryItem;
import com.fradou.nutrition.back.service.PantryItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pantryItems")
@AllArgsConstructor
@Api(value = "/pantryItems", description = "Controller for pantry items operation")
public class PantryItemController {

    private PantryItemService pantryItemService;

    @GetMapping
    @ApiOperation(value = "Get list of pantry items, base on params")
    @ApiImplicitParams({
            @ApiImplicitParam()
    })
    public List<PantryItem> getPantryItems() {
        return pantryItemService.getAllPantryItems();
    }

}
