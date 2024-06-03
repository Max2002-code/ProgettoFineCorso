package com.example.ProgettoFineCorso.repository;

import com.example.ProgettoFineCorso.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}