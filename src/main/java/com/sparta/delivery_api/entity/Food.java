package com.sparta.delivery_api.entity;

import com.sparta.delivery_api.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foodId;

    @Column(nullable = false)
    private String foodName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodPlaceId")
    private FoodPlace foodPlace;

    @Column(nullable = false)
    private Long price;

    public Food(FoodDto foodDto) {
        this.foodName = foodDto.getFoodName();
        this.price = foodDto.getPrice();
    }
}
