package com.sparta.delivery_api.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
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
    private List<OrderMenu> selectedMenu;

    @Column
    private long totalPrice;
}
