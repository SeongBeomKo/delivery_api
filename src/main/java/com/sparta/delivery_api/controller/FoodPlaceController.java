package com.sparta.delivery_api.controller;

import com.sparta.delivery_api.dto.FoodDto;
import com.sparta.delivery_api.dto.RestaurantDto;
import com.sparta.delivery_api.dto.ShowMenuResponseDto;
import com.sparta.delivery_api.entity.FoodPlace;
import com.sparta.delivery_api.service.FoodPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodPlaceController {

    private final FoodPlaceService foodPlaceService;

    @PostMapping("/restaurant/register")
    public FoodPlace registerFoodPlace(@RequestBody RestaurantDto restaurantDto) {
        return foodPlaceService.registerFoodPlace(restaurantDto);
    }

    @GetMapping("/restaurants")
    public List<FoodPlace> showAllFoodPlace() {
        return foodPlaceService.showAllFoodPlace();
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createMenu(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList) {
       foodPlaceService.createMenu(restaurantId, foodDtoList);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<ShowMenuResponseDto> showMenu(@PathVariable Long restaurantId) {
       return foodPlaceService.showMenu(restaurantId);
    }
}
