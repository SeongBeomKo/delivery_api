package com.sparta.delivery_api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderResponseDto {

    private String restaurantName;

    private List<OrderMenuResponseDto> foods;

    private long deliveryFee;

    private long totalPrice;

}
