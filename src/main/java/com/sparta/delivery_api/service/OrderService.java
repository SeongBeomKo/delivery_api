package com.sparta.delivery_api.service;

import com.sparta.delivery_api.dto.OrderRequestDto;
import com.sparta.delivery_api.entity.Food;
import com.sparta.delivery_api.entity.OrderMenu;
import com.sparta.delivery_api.entity.Ordering;
import com.sparta.delivery_api.repository.FoodRepository;
import com.sparta.delivery_api.repository.OrderingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final FoodRepository foodRepository;
    private final OrderingRepository orderingRepository;

    @Transactional
    public Ordering saveOrder(OrderRequestDto orderRequestDto) {
        Ordering ordering = new Ordering();

        long totalPrice = 0;
        ordering.setFoodPlaceId(orderRequestDto.getFoodPlaceId());
        for(Long foodId : orderRequestDto.getSelectedMenu().keySet()) {
            OrderMenu orderMenu = new OrderMenu();
            orderMenu.setQuantity(orderRequestDto.getSelectedMenu().get(foodId));
            Food food = foodRepository.findById(foodId).orElseThrow(
                    () -> new NullPointerException("음식이 없습니다."));
            orderMenu.setFood(food);
            totalPrice += food.getPrice();
            ordering.getSelectedMenu().add(orderMenu);
        }
        ordering.setTotalPrice(totalPrice);
        return orderingRepository.save(ordering);
    }

}
