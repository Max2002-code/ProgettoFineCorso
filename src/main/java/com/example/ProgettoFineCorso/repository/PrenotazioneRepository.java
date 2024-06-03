package com.example.ProgettoFineCorso.repository;

import com.example.ProgettoFineCorso.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByUtente(String utente);
    List<Prenotazione> findByEventoId(Long eventoId);
}
