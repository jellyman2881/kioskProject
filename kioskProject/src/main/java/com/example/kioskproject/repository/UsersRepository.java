package com.example.kioskproject.repository;

import com.example.kioskproject.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByUserLoginId(String userLoginId);
}
