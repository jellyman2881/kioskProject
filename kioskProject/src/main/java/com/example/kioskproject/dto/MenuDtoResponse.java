package com.example.kioskproject.dto;

import com.example.kioskproject.domain.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuDtoResponse {
    private Long menuId;
    private String menuName;
    private int menuPrice;
    private int menuStock;
    private char menuState;
    private String origFilename;
    private String filename;
    private String categoryDtoName;
    private int menuSortingNumber;
    private char menuDouble;
    private int menuDoublePrice;

    public MenuDtoResponse(Menu menu) {
        this.menuId = menu.getMenuId();
        this.menuName = menu.getMenuName();
        this.menuPrice = menu.getMenuPrice();
        this.menuStock = menu.getMenuStock();
        this.menuState = menu.getMenuState();
        this.origFilename = menu.getOrigFilename();
        this.filename = menu.getFilename();
        this.menuSortingNumber = menu.getMenuSortingNumber();
        this.categoryDtoName = menu.getCategory().getCategoryName();
        this.menuDouble = menu.getMenuDouble();
        this.menuDoublePrice = menu.getMenuDoublePrice();

    }
}
