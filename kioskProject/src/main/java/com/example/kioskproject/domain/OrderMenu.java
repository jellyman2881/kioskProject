package com.example.kioskproject.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "ORDER_MENU_SEQ_GENERATOR",
        sequenceName = "ORDER_MENU_SEQ",
        initialValue = 1, allocationSize = 1)

public class OrderMenu {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ORDER_MENU_SEQ_GENERATOR")
    private Long orderMenuId;
    private int orderMenuQuentity;
    private int orderMenuOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private Menu menu;

@Builder
    public OrderMenu(Long orderMenuId, int orderMenuQuentity, int orderMenuOption, Orders orders, Menu menu) {
        this.orderMenuId = orderMenuId;
        this.orderMenuQuentity = orderMenuQuentity;
        this.orderMenuOption = orderMenuOption;
        this.orders = orders;
        this.menu = menu;
    }
}
