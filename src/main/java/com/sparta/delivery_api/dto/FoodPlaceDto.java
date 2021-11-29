package com.sparta.delivery_api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FoodPlaceDto {

    private String foodPlaceName;

    private long minOrderPrice;

    private long deliveryFee;

}
