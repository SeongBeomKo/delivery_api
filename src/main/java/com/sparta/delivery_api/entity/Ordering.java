package com.sparta.delivery_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column
    private long foodPlaceId;

    @OneToMany(mappedBy = "ordering")
    @JsonIgnore
    private List<OrderMenu> selectedMenu;

    @Column
    private long totalPrice;

    public Ordering(long foodPlaceId, long totalPrice, long deliveryFee, long minValPrice) {
        if(totalPrice - deliveryFee < minValPrice)
            throw new IllegalArgumentException("최소 주문 금액 미충족");
        this.foodPlaceId = foodPlaceId;
        this.totalPrice = totalPrice;
    }

}
