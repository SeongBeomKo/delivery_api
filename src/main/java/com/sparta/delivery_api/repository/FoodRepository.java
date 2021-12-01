package com.sparta.delivery_api.repository;

import com.sparta.delivery_api.entity.Food;
import com.sparta.delivery_api.entity.FoodPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {
    boolean existsByNameAndFoodPlace(String name, FoodPlace foodPlace);
    List<Food> findAllByFoodPlace(FoodPlace foodPlace);
}
