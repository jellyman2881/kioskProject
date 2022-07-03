package com.example.kioskproject.dto;

import com.example.kioskproject.domain.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuDto {
    private Long menuId;
    private String menuName;
    private int menuPrice;
    private int menuStock;
    private Boolean menuState;
    private String menuImg;


 @Builder
    public MenuDto(Long menuId, String menuName, int menuPrice, int menuStock, Boolean menuState, String menuImg){
     this.menuId = menuId;
     this.menuName = menuName;
     this.menuPrice = menuPrice;
     this.menuStock = menuStock;
     this.menuState = menuState;
     this.menuImg = menuImg;
 }
}
