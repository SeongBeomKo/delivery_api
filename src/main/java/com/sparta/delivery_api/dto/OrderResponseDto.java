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

    private List<menuDto> orderMenu;

    private long deliveryFee;

    private long totalPrice;
}
