package com.example.kioskproject.controller;

import com.example.kioskproject.domain.OrderMenu;
import com.example.kioskproject.dto.OrderMenuDto;
import com.example.kioskproject.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;


    @PostMapping("order/{totalPrice}")
    public Long addOrder(@PathVariable  int totalPrice, @RequestBody List<OrderMenuDto> orderMenuDto) {
        System.out.println(orderMenuDto);
        return ordersService.addOrder(totalPrice,orderMenuDto);

    }
}
