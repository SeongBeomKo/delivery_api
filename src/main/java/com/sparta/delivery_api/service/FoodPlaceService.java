package com.sparta.delivery_api.service;

import com.sparta.delivery_api.dto.FoodDto;
import com.sparta.delivery_api.entity.Food;
import com.sparta.delivery_api.entity.FoodPlace;
import com.sparta.delivery_api.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodPlaceService {

    private final FoodRepository foodRepository;

    @Transactional
    public ResponseEntity<FoodPlace> addMenu(FoodPlace foodPlace, List<FoodDto> menu) {

        List<Food> foodPlaceMenu = foodPlace.getMenu();

        for (FoodDto newFood : menu) {
            if (newFood.getPrice() < 100 || newFood.getPrice() > 1000000)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            if (newFood.getPrice() % 100 != 0)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            if (foodRepository.existsByNameAndFoodPlace(newFood.getName(), foodPlace))
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        HashSet<String> hs = new HashSet<>();
        for(FoodDto newFood : menu)
            hs.add(newFood.getName());

        if(hs.size() != menu.size())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        for (FoodDto newFood : menu) {
            assert foodPlaceMenu != null;
            foodPlaceMenu.add(foodRepository.save(new Food(newFood, foodPlace)));
        }
        foodPlace.setMenu(foodPlaceMenu);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
