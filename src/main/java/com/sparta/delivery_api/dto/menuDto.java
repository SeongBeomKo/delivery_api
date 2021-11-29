package com.sparta.delivery_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class menuDto {

    private String foodName;

    private long price;

    private int quantity;

}
