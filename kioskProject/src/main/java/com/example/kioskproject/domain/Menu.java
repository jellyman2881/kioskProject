package com.example.kioskproject.domain;

import lombok.*;

import javax.persistence.*;

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
    private char menuState;
    private String origFilename;
    private String filename;
    private String filePath;

    @Builder
    public Menu(Long menuId, String menuName, int menuPrice, int menuStock, char menuState, String origFilename,String filename,String filePath) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuStock = menuStock;
        this.menuState = menuState;
        this.origFilename = origFilename;
        this.filename =filename;
        this.filePath = filePath;

    }
}
