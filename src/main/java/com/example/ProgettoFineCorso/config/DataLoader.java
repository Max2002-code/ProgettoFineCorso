package com.example.ProgettoFineCorso.config;

import com.example.ProgettoFineCorso.model.Role;
import com.example.ProgettoFineCorso.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findByName("ROLE_USER") == null) {
            roleRepository.save(new Role("ROLE_USER"));
        }

        if (roleRepository.findByName("ROLE_ORGANIZZATORE") == null) {
            roleRepository.save(new Role("ROLE_ORGANIZZATORE"));
        }
    }
}