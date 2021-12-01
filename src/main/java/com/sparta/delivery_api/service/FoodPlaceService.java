package com.sparta.delivery_api.service;

import com.sparta.delivery_api.dto.FoodDto;
import com.sparta.delivery_api.entity.FoodPlace;
import com.sparta.delivery_api.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodPlaceService {

    private final FoodRepository foodRepository;

    public boolean validCheck(List<FoodDto> menu, FoodPlace foodPlace) {
        for (FoodDto newFood : menu) {
            if (foodRepository.existsByNameAndFoodPlace(newFood.getName(), foodPlace))
                return true;
        }
        return false;
    }
}
