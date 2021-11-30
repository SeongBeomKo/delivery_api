package com.sparta.delivery_api.repository;

import com.sparta.delivery_api.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    boolean existsByName(String name);
    Optional<Food> findByName(String name);
}
