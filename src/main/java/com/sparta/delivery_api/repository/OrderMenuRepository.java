package com.sparta.delivery_api.repository;

import com.sparta.delivery_api.entity.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMenuRepository extends JpaRepository<OrderMenu, Long> {
}
