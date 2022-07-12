package com.example.kioskproject.dto;

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
    private String filePath;
    private Long categoryDtoId;
    private int menuSortingNumber;

    public MenuDtoRequest(Menu menu) {
        this.menuName = menu.getMenuName();
        this.menuPrice = menu.getMenuPrice();
        this.menuStock = menu.getMenuStock();
        this.menuState = menu.getMenuState();
        this.origFilename = menu.getOrigFilename();
        this.filename = menu.getFilename();
        this.filePath = menu.getFilePath();
        this.menuSortingNumber = menu.getMenuSortingNumber();
        this.categoryDtoId = menu.getCategory().getCategoryId();
    }
}
