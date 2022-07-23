package com.example.kioskproject.repository;

import com.example.kioskproject.domain.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMenuRepository extends JpaRepository<OrderMenu,Long> {
}
