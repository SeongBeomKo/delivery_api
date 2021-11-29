package com.sparta.delivery_api.repository;

import com.sparta.delivery_api.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Food, Long> {
}
