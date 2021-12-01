package com.sparta.delivery_api.controller;

import com.sparta.delivery_api.dto.FoodDto;
import com.sparta.delivery_api.dto.RestaurantDto;
import com.sparta.delivery_api.dto.ShowMenuResponseDto;
import com.sparta.delivery_api.entity.Food;
import com.sparta.delivery_api.entity.FoodPlace;
import com.sparta.delivery_api.repository.FoodPlaceRepository;
import com.sparta.delivery_api.repository.FoodRepository;
import com.sparta.delivery_api.service.FoodPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodPlaceController {

    private final FoodPlaceRepository foodPlaceRepository;
    private final FoodPlaceService foodPlaceService;
    private final FoodRepository foodRepository;

    @PostMapping("/restaurant/register")
    public FoodPlace registerFoodPlace(@RequestBody RestaurantDto restaurantDto) {
        return foodPlaceRepository.save(new FoodPlace(restaurantDto));
    }

    @GetMapping("/restaurants")
    public List<FoodPlace> showAllFoodPlace() {
        return foodPlaceRepository.findAll();
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createMenu(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList) {
        FoodPlace foodPlace = foodPlaceRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("no such a restaurant exist"));
        HashSet<String> hs = new HashSet<>();
        for (FoodDto newfood : foodDtoList) {
            hs.add(newfood.getName());
        }
        if (hs.size() != foodDtoList.size())
            throw new IllegalArgumentException("input data 중복값 발견");
        if (foodPlaceService.validCheck(foodDtoList, foodPlace))
            throw new IllegalArgumentException("이미 포함 됨");
        for (FoodDto newfood : foodDtoList) {
            Food food = new Food(newfood, foodPlace);
            if (food.getPrice() < 100 || food.getPrice() > 1000000)
                throw new IllegalArgumentException("가격 설정 범위 위반");
            if (food.getPrice() % 100 != 0)
                throw new IllegalArgumentException("가격 설정 단위 위반");
            foodRepository.save(food);
        }
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<ShowMenuResponseDto> showMenu(@PathVariable Long restaurantId) {
        FoodPlace foodPlace = foodPlaceRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("음식점이 없습니다."));
        List<ShowMenuResponseDto> menu = new ArrayList<>();
        List<Food> foodList = foodRepository.findAllByFoodPlace(foodPlace);
        for (Food food : foodList) {
            ShowMenuResponseDto showMenuResponseDto = new ShowMenuResponseDto(food.getFoodId(), food.getName(), food.getPrice());
            menu.add(showMenuResponseDto);
        }
        return menu;
    }
}
