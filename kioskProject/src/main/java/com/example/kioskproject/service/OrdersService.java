package com.example.kioskproject.service;

import com.example.kioskproject.domain.Menu;
import com.example.kioskproject.domain.OrderMenu;
import com.example.kioskproject.domain.Orders;
import com.example.kioskproject.dto.OrderMenuDto;
import com.example.kioskproject.repository.MenuRepository;
import com.example.kioskproject.repository.OrderMenuRepository;
import com.example.kioskproject.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final MenuRepository menuRepository;
    private final OrderMenuRepository orderMenuRepository;

    public Long addOrder(int totalPrice, List<OrderMenuDto> orderMenuDto) {

        Orders orders = Orders.builder()
                .orderPrice(totalPrice)
                .orderTime(LocalDateTime.now())
                .build();
        ordersRepository.save(orders);

        for (OrderMenuDto orderMenuDto1 : orderMenuDto) {
            Optional<Menu> menu = menuRepository.findById(orderMenuDto1.getMenuId());
            Menu menuEntity = menu.orElse(null);
            if (menuEntity == null) return null;

            OrderMenu orderMenu = OrderMenu.builder()
                    .orderMenuQuentity(orderMenuDto1.getOrderMenuQuentity())
                    .orderMenuOption(orderMenuDto1.getOrderMenuOption())
                    .orders(orders)
                    .menu(menuEntity)
                    .build();

            orderMenuRepository.save(orderMenu);
        }


        return orders.getOrderId();
    }
}
