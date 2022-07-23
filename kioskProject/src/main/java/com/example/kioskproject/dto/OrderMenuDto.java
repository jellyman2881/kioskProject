package com.example.kioskproject.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString

public class OrderMenuDto {

    private int orderMenuQuentity;
    private int orderMenuOption;
    private Long menuId;
  //  private List<OrderMenuDto> orderMenuDtoList;
}
