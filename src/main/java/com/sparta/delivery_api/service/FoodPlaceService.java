package com.sparta.delivery_api.service;

import com.sparta.delivery_api.dto.FoodDto;
import com.sparta.delivery_api.entity.Food;
import com.sparta.delivery_api.entity.FoodPlace;
import com.sparta.delivery_api.repository.FoodPlaceRepository;
import com.sparta.delivery_api.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodPlaceService {

    private final FoodRepository foodRepository;

    @Transactional
    public void addMenu(FoodPlace foodPlace, List<FoodDto> menu) {
        for(FoodDto newFood : menu) {
            if(!foodRepository.existsByfoodName(newFood.getFoodName()))
                foodPlace.getMenu().add(foodRepository.save(new Food(newFood)));
        }
    }


}
