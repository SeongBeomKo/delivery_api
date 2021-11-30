package com.sparta.delivery_api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    private String name;

    private long minOrderPrice;

    private long deliveryFee;

}
