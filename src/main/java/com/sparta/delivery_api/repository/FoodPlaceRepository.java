package com.sparta.delivery_api.repository;

import com.sparta.delivery_api.entity.FoodPlace;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodPlaceRepository extends JpaRepository<FoodPlace, Long> {
}
