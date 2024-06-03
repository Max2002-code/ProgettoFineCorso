package com.example.ProgettoFineCorso.service;

import com.example.ProgettoFineCorso.model.Prenotazione;
import com.example.ProgettoFineCorso.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    // Metodo per salvare una prenotazione
    public void salvaPrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }
}
