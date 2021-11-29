package com.sparta.delivery_api.entity;


import com.sparta.delivery_api.dto.FoodPlaceDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class FoodPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foodPlaceId;

    @Column
    private String name;

    @Column
    private long minOrderPrice;

    @Column
    private long deliveryFee;

    @Nullable
    @OneToMany(mappedBy = "foodPlace")
    private List<Food> menu;

    public FoodPlace (FoodPlaceDto foodPlaceDto) {
        this.name = foodPlaceDto.getName();
        this.minOrderPrice = foodPlaceDto.getMinOrderPrice();
        this.deliveryFee = foodPlaceDto.getDeliveryFee();
    }

}
