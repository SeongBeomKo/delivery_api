package com.sparta.delivery_api.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FoodDto {

    private String name;

    private long price;
}
