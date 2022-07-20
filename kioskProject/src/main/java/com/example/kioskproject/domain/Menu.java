package com.example.kioskproject.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "MENU_SEQ_GENERATOR",
        sequenceName = "MENU_SEQ",
        initialValue = 2, allocationSize = 2)

public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_SEQ_GENERATOR")
    private Long menuId;
    private String menuName;
    private int menuPrice;
    private int menuStock;
    private char menuState;
    private int menuSortingNumber;
    private String origFilename;
    private String filename;
    private char menuDouble;
    private int menuDoublePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @Builder
    public Menu(int menuDoublePrice, char menuDouble, int menuSortingNumber, Category category, Long menuId, String menuName, int menuPrice, int menuStock, char menuState, String origFilename, String filename) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuStock = menuStock;
        this.menuState = menuState;
        this.origFilename = origFilename;
        this.filename =filename;
        this.category = category;
        this.menuSortingNumber = menuSortingNumber;
        this.menuDouble = menuDouble;
        this.menuDoublePrice =menuDoublePrice;
    }



}
