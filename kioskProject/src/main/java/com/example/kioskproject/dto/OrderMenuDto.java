package com.example.kioskproject.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class OrderMenuDto {

    private Long orderMenuId;
    private int orderMenuQuentity;
    private int orderMenuOption;
    private MenuDto menuDto;

}
