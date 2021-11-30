package com.sparta.delivery_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShowMenuResponseDto {

    private long id;

    private String name;

    private Long price;
}
