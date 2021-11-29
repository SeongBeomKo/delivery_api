package com.sparta.delivery_api.controller;

import com.sparta.delivery_api.dto.FoodDto;
import com.sparta.delivery_api.dto.FoodPlaceDto;
import com.sparta.delivery_api.entity.Food;
import com.sparta.delivery_api.entity.FoodPlace;
import com.sparta.delivery_api.repository.FoodPlaceRepository;
import com.sparta.delivery_api.service.FoodPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant")
public class FoodPlaceController {

    private final FoodPlaceRepository foodPlaceRepository;
    private final FoodPlaceService foodPlaceService;



    @PostMapping("/register")
    public String registerFoodPlace(@RequestBody FoodPlaceDto foodPlaceDto) {
        FoodPlace foodPlace = new FoodPlace(foodPlaceDto);
        foodPlaceRepository.save(foodPlace);
        //실패 하면?!?
        return "success";
    }

    @GetMapping("/")
    public List<FoodPlace> showAllFoodPlace() {
        return foodPlaceRepository.findAllByFoodPlaceIdOrderByNameAsc();
    }

    @PostMapping("/{restaurantId}/food/register")
    public String createMenu(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList) {
        FoodPlace foodPlace = foodPlaceRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("no such a restaurant exist"));
        foodPlaceService.addMenu(foodPlace, foodDtoList);
        foodPlaceRepository.save(foodPlace);
        //실패 하면?!
        return "메뉴 생성 성공";
    }

    @GetMapping("/{restaurantId}/foods")
    public List<Food> showMenu(@PathVariable Long restaurantId) {
        FoodPlace foodPlace = foodPlaceRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("음식점이 없습니다."));
        return foodPlace.getMenu();
    }
}
