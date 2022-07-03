package com.example.kioskproject.repository;

import com.example.kioskproject.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {

}
