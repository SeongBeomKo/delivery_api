package com.sparta.delivery_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public class OrderRequestDto {

    private final long foodPlaceId;

    private final HashMap<Long, Integer> selectedMenu;
}
