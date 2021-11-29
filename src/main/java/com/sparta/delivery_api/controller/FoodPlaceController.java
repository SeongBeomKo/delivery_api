package com.sparta.delivery_api.controller;

import com.sparta.delivery_api.dto.menuDto;
import com.sparta.delivery_api.dto.FoodPlaceDto;
import com.sparta.delivery_api.entity.Food;
import com.sparta.delivery_api.entity.FoodPlace;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class FoodPlaceController {

    @PostMapping("/register")
    public String registerFoodPlace(@RequestBody FoodPlaceDto foodPlaceDto) {
        return "";
    }

    @GetMapping("/")
    public List<FoodPlace> showAllFoodPlace() {

    }

    @PostMapping("/{restaurantId}/food/register")
    public String createMenu(@PathVariable Long restaurantId, @RequestBody List<menuDto> foodDtoList) {
        return "";
    }

    @GetMapping("/{restaurantId}/foods")
    public List<menuDto> showMenu(@PathVariable Long restaurantId) {

    }
}
