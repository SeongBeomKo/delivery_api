package com.sparta.delivery_api.entity;

import com.sparta.delivery_api.dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class FoodPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private long minOrderPrice;

    @Column
    private long deliveryFee;

    public FoodPlace (RestaurantDto restaurantDto) {
        if(restaurantDto.getMinOrderPrice() < 1000 || restaurantDto.getMinOrderPrice() > 100000)
            throw new IllegalArgumentException("최저 주문 금액 미충족");
        if(restaurantDto.getMinOrderPrice() % 100 != 0)
            throw new IllegalArgumentException("최저 주문 금액 단위 위반");
        if(restaurantDto.getDeliveryFee() % 500 != 0)
            throw new IllegalArgumentException("배달비 단위 위반");
        if(restaurantDto.getDeliveryFee() < 0 || restaurantDto.getDeliveryFee() > 10000)
            throw new IllegalArgumentException("배달비 범위 위반");
        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }

}
