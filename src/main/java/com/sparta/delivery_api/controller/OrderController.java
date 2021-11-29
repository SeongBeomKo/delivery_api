package com.sparta.delivery_api.controller;

import com.sparta.delivery_api.dto.OrderRequestDto;
import com.sparta.delivery_api.dto.OrderResponseDto;
import com.sparta.delivery_api.entity.FoodPlace;
import com.sparta.delivery_api.entity.Ordering;
import com.sparta.delivery_api.repository.FoodPlaceRepository;
import com.sparta.delivery_api.repository.OrderingRepository;
import com.sparta.delivery_api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final FoodPlaceRepository foodPlaceRepository;
    private final OrderingRepository orderingRepository;

    @PostMapping("/order/request")
    public OrderResponseDto getOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return convertingType(orderService.saveOrder(orderRequestDto));
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> showAllOrders() {
        List<Ordering> allOrders = orderingRepository.findAll();
        List<OrderResponseDto> allOrdersConverted = new ArrayList<>();
        for(Ordering ordering : allOrders)
            allOrdersConverted.add(convertingType(ordering));
        return allOrdersConverted;
    }

    public OrderResponseDto convertingType(Ordering ordering) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        FoodPlace foodPlace = foodPlaceRepository.findById(ordering.getFoodPlaceId()).orElseThrow(
                () -> new NullPointerException("음식점이 없습니다"));
        orderResponseDto.setRestaurantName(foodPlace.getName());
        orderResponseDto.setOrderMenu(ordering.getSelectedMenu());
        orderResponseDto.setDeliveryFee(foodPlace.getDeliveryFee());
        orderResponseDto.setTotalPrice(ordering.getTotalPrice());
        return orderResponseDto;
    }
}
