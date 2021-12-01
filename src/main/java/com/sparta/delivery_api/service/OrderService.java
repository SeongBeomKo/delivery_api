package com.sparta.delivery_api.service;

import com.sparta.delivery_api.dto.MenuOrderDto;
import com.sparta.delivery_api.dto.OrderRequestDto;
import com.sparta.delivery_api.entity.Food;
import com.sparta.delivery_api.entity.FoodPlace;
import com.sparta.delivery_api.entity.OrderMenu;
import com.sparta.delivery_api.entity.Ordering;
import com.sparta.delivery_api.repository.FoodPlaceRepository;
import com.sparta.delivery_api.repository.FoodRepository;
import com.sparta.delivery_api.repository.OrderMenuRepository;
import com.sparta.delivery_api.repository.OrderingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final FoodRepository foodRepository;
    private final OrderingRepository orderingRepository;
    private final FoodPlaceRepository foodPlaceRepository;
    private final OrderMenuRepository orderMenuRepository;

    @Transactional
    public Ordering saveOrder(OrderRequestDto orderRequestDto) {

        List<OrderMenu> selectedMenu = new ArrayList<>();
        long totalPrice = 0;

        for(MenuOrderDto menuOrderDto : orderRequestDto.getFoods()) {
            Food food = foodRepository.findById(menuOrderDto.getId()).orElseThrow(
                    () -> new NullPointerException("음식이 없습니다."));
            totalPrice += food.getPrice() * menuOrderDto.getQuantity();
        }

        FoodPlace foodPlace = foodPlaceRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new NullPointerException("배달비가 없습니다."));
        Ordering ordering = new Ordering(orderRequestDto.getRestaurantId(), totalPrice + foodPlace.getDeliveryFee(), foodPlace.getDeliveryFee(), foodPlace.getMinOrderPrice());

        for(MenuOrderDto menuOrderDto : orderRequestDto.getFoods()) {
            Food food = foodRepository.findById(menuOrderDto.getId()).orElseThrow(
                    () -> new NullPointerException("음식이 없습니다."));
            OrderMenu orderMenu = new OrderMenu(menuOrderDto, food, ordering);
            selectedMenu.add(orderMenu);
            orderMenuRepository.save(orderMenu);
        }

        ordering.setSelectedMenu(selectedMenu);
        return orderingRepository.save(ordering);
    }
}
