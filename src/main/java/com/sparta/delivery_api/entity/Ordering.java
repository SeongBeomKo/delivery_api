package com.sparta.delivery_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    public Ordering(long foodPlaceId, long totalPrice) {
        this.foodPlaceId = foodPlaceId;
        this.totalPrice = totalPrice;
    }

}
