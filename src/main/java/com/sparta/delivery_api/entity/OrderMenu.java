package com.sparta.delivery_api.entity;

import com.sparta.delivery_api.dto.MenuOrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderMenuId;

    @OneToOne
    @JoinColumn(name = "foodId")
    private Food food;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Ordering ordering;

    private int quantity;

    public OrderMenu(MenuOrderDto menuOrderDto, Food food, Ordering ordering) {
        if(menuOrderDto.getQuantity() < 1 || menuOrderDto.getQuantity() > 100)
            throw new IllegalArgumentException("음식 주문 수량 에러");
        this.quantity = menuOrderDto.getQuantity();
        this.food = food;
        this.ordering = ordering;
    }
}
