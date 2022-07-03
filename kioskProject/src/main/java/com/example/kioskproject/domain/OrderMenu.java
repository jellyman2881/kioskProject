package com.example.kioskproject.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString
public class OrderMenu {

    @Id
    private Long orderMenuId;
    private int orderMenuQuentity;
    private int orderMenuOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID")
    private Menu menu;
}
