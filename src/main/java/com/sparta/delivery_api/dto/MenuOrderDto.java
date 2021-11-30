package com.sparta.delivery_api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuOrderDto {

    private long id;

    private int quantity;
}
