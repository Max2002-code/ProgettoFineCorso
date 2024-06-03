package com.example.ProgettoFineCorso.repository;

import com.example.ProgettoFineCorso.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}