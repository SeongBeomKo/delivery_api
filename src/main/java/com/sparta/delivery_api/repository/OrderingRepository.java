package com.sparta.delivery_api.repository;

import com.sparta.delivery_api.entity.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderingRepository extends JpaRepository<Ordering, Long> {
}
