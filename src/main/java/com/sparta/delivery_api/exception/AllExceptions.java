package com.sparta.delivery_api.exception;

import com.sparta.delivery_api.dto.RestaurantDto;
import com.sparta.delivery_api.entity.Food;
import org.springframework.stereotype.Component;

@Component
public class AllExceptions {

    public static final int MINIMUM_ORDER_PRICE = 1000;
    public static final int MAXIMUM_ORDER_PRICE = 100000;
    public static final int ORDER_PRICE_UNIT = 100;
    public static final int DELIVERY_FEE_UNIT = 500;
    public static final int MAXIMUM_DELIVERY_FEE = 10000;
    public static final int MINIMUM_DELIVERY_FEE = 0;
    public static final int MINIMUM_FOOD_PRICE = 100;
    public static final int MAXIMUM_FOOD_PRICE = 1000000;
    public static final int FOOD_PRICE_UNIT = 100;



    public static void foodPlaceExceptions(RestaurantDto restaurantDto) {
        if(restaurantDto.getMinOrderPrice() < MINIMUM_ORDER_PRICE || restaurantDto.getMinOrderPrice() > MAXIMUM_ORDER_PRICE)
            throw new IllegalArgumentException("최저 주문 금액 미충족");
        if(restaurantDto.getMinOrderPrice() % ORDER_PRICE_UNIT != 0)
            throw new IllegalArgumentException("최저 주문 금액 단위 위반");
        if(restaurantDto.getDeliveryFee() % DELIVERY_FEE_UNIT != 0)
            throw new IllegalArgumentException("배달비 단위 위반");
        if(restaurantDto.getDeliveryFee() < MINIMUM_DELIVERY_FEE || restaurantDto.getDeliveryFee() > MAXIMUM_DELIVERY_FEE)
            throw new IllegalArgumentException("배달비 범위 위반");
    }

    public static void foodException(Food food) {
        if (food.getPrice() < MINIMUM_FOOD_PRICE || food.getPrice() > MAXIMUM_FOOD_PRICE)
            throw new IllegalArgumentException("가격 설정 범위 위반");
        if (food.getPrice() % FOOD_PRICE_UNIT != 0)
            throw new IllegalArgumentException("가격 설정 단위 위반");
    }

    public static void orderException(long totalPrice, long deliveryFee, long minOrderPrice) {
        if(totalPrice - deliveryFee < minOrderPrice)
            throw new IllegalArgumentException("최소 주문 금액 미충족");
    }
}
