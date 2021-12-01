package com.sparta.delivery_api.controller;

import com.sparta.delivery_api.dto.OrderRequestDto;
import com.sparta.delivery_api.dto.OrderResponseDto;
import com.sparta.delivery_api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/request")
    public OrderResponseDto getOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return orderService.convertingType(orderService.saveOrder(orderRequestDto));
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> showAllOrders() {
        return orderService.showAllOrders();
    }
}
