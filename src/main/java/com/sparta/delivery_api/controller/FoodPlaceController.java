package com.sparta.delivery_api.controller;

import com.sparta.delivery_api.dto.FoodDto;
import com.sparta.delivery_api.dto.RestaurantDto;
import com.sparta.delivery_api.dto.ShowMenuResponseDto;
import com.sparta.delivery_api.entity.Food;
import com.sparta.delivery_api.entity.FoodPlace;
import com.sparta.delivery_api.repository.FoodPlaceRepository;
import com.sparta.delivery_api.service.FoodPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodPlaceController {

    private final FoodPlaceRepository foodPlaceRepository;
    private final FoodPlaceService foodPlaceService;

    @PostMapping("/restaurant/register")
    public ResponseEntity<FoodPlace> registerFoodPlace(@RequestBody RestaurantDto restaurantDto) {
        FoodPlace foodPlace = new FoodPlace(restaurantDto);
        if(restaurantDto.getMinOrderPrice() < 1000 || restaurantDto.getMinOrderPrice() > 100000)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(restaurantDto.getMinOrderPrice() % 100 != 0)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(restaurantDto.getDeliveryFee() % 500 != 0)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if(restaurantDto.getDeliveryFee() < 0 || restaurantDto.getDeliveryFee() > 10000)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        ResponseEntity<FoodPlace> registerOk = new ResponseEntity<>(foodPlaceRepository.save(foodPlace), HttpStatus.OK);
        //실패 하면?!?
        return registerOk;
    }

    @GetMapping("/restaurants")
    public List<FoodPlace> showAllFoodPlace() {
        return foodPlaceRepository.findAll();
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public ResponseEntity<FoodPlace> createMenu(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList) {
        FoodPlace foodPlace = foodPlaceRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("no such a restaurant exist"));
        return foodPlaceService.addMenu(foodPlace, foodDtoList);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<ShowMenuResponseDto> showMenu(@PathVariable Long restaurantId) {
        FoodPlace foodPlace = foodPlaceRepository.findById(restaurantId).orElseThrow(
                () -> new NullPointerException("음식점이 없습니다."));
        List<ShowMenuResponseDto> menu = new ArrayList<>();
        for(Food food : foodPlace.getMenu()) {
            ShowMenuResponseDto showMenuResponseDto = new ShowMenuResponseDto(food.getFoodId(), food.getName(), food.getPrice());
            menu.add(showMenuResponseDto);
        }
        return menu;
    }
}
