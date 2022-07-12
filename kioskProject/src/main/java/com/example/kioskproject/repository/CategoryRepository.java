package com.example.kioskproject.repository;

import com.example.kioskproject.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllByOrderByCategorySortingNumber();
}
