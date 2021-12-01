package com.sparta.delivery_api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.delivery_api.dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class FoodPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private long minOrderPrice;

    @Column
    private long deliveryFee;

    @OneToMany(mappedBy = "foodPlace")
    @JsonIgnore
    private List<Food> menu;

    public FoodPlace (RestaurantDto restaurantDto) {
        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }

}
