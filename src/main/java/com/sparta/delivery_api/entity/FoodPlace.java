package com.sparta.delivery_api.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class FoodPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foodPlaceId;

    @Column
    private String foodPlaceName;

    @Column
    private long minOrderPrice;

    @Column
    private long deliveryFee;

    @OneToMany
    private HashSet<Food> menu;

}
