package com.example.kioskproject.repository;

import com.example.kioskproject.domain.Category;
import com.example.kioskproject.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    List<Menu> findByCategory_CategoryIdOrderByMenuSortingNumber(Long categoryId);
}
