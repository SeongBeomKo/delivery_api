package com.sparta.delivery_api.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OrderMenuResponseDto {

    private String name;

    private int quantity;

    private long price;
}
