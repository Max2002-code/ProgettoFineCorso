package com.example.ProgettoFineCorso.service;

import com.example.ProgettoFineCorso.model.Evento;
import com.example.ProgettoFineCorso.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // Metodo per salvare un evento
    public void salvaEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    // Metodo per trovare un evento per ID
    public Evento trovaEventoPerId(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    // Metodo per eliminare un evento per ID
    public void eliminaEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    // Metodo per trovare tutti gli eventi
    public List<Evento> trovaTuttiEventi() {
        return eventoRepository.findAll();
    }
}
