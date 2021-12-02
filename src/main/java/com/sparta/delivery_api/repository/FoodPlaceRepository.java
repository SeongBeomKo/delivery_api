package com.sparta.delivery_api.repository;

import com.sparta.delivery_api.entity.FoodPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodPlaceRepository extends JpaRepository<FoodPlace, Long> {
}
