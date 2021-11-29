package com.sparta.delivery_api.controller;

import com.sparta.delivery_api.dto.OrderRequestDto;
import com.sparta.delivery_api.dto.OrderResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @PostMapping("/order/request")
    public OrderResponseDto getOrder(@RequestBody OrderRequestDto orderRequestDto) {

    }

    @GetMapping("/orders")
    public List<OrderResponseDto> showAllOrders() {

    }
}
