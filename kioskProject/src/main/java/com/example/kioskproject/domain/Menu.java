package com.example.kioskproject.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long menuId;
    private String menuName;
    private int menuPrice;
    private int menuStock;
    private Boolean menuState;
    private String menuImg;


    @Builder
    public Menu(Long menuId, String menuName, int menuPrice, int menuStock, Boolean menuState, String menuImg) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuStock = menuStock;
        this.menuState = menuState;
        this.menuImg = menuImg;
    }
}
