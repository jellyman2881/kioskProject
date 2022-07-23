package com.example.kioskproject.repository;

import com.example.kioskproject.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
}
