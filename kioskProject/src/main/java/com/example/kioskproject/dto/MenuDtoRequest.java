package com.example.kioskproject.dto;

import com.example.kioskproject.domain.Category;
import com.example.kioskproject.domain.Menu;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuDtoRequest {
    private String menuName;
    private int menuPrice;
    private int menuStock;
    private char menuState;
    private String origFilename;
    private String filename;
    private Long categoryDtoId;
    private int menuSortingNumber;
    private char menuDouble;
    private int menuDoublePrice;
    private String pastFileName;


    public MenuDtoRequest(Menu menu) {
        this.menuName = menu.getMenuName();
        this.menuPrice = menu.getMenuPrice();
        this.menuStock = menu.getMenuStock();
        this.menuState = menu.getMenuState();
        this.origFilename = menu.getOrigFilename();
        this.filename = menu.getFilename();
        this.menuSortingNumber = menu.getMenuSortingNumber();
        this.categoryDtoId = menu.getCategory().getCategoryId();
        this.menuDouble = menu.getMenuDouble();
        this.menuDoublePrice = menu.getMenuDoublePrice();
    }

    public Menu toEntity(Category category){

        return Menu.builder()
                .origFilename(this.getOrigFilename())
                .filename(this.getFilename())
                .menuName(this.getMenuName())
                .menuPrice(this.getMenuPrice())
                .menuState(this.getMenuState())
                .menuStock(this.getMenuStock())
                .menuSortingNumber(this.getMenuSortingNumber())
                .category(category)
                .menuDouble(this.getMenuDouble())
                .menuDoublePrice((this.getMenuDoublePrice()))
                .build();
    }
}
