package com.example.ProgettoFineCorso.repository;

import com.example.ProgettoFineCorso.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
