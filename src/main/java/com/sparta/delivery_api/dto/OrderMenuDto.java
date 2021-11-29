package com.sparta.delivery_api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderMenuDto {

    private long foodId;

    private int quantity;
}
