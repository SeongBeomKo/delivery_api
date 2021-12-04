package com.sparta.delivery_api.entity;

import com.sparta.delivery_api.dto.RestaurantDto;
import com.sparta.delivery_api.exception.AllExceptions;
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
        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }

}
