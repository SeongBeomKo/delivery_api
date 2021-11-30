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
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private FoodPlace foodPlace;

    @Column(nullable = false)
    private Long price;

    @OneToOne(mappedBy = "food")
    private OrderMenu orderMenu;

    public Food(FoodDto foodDto, FoodPlace foodPlace) {
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.foodPlace = foodPlace;
    }
}
