package com.example.ProgettoFineCorso.controller;

import com.example.ProgettoFineCorso.model.Evento;
import com.example.ProgettoFineCorso.model.Prenotazione;
import com.example.ProgettoFineCorso.service.EventoService;
import com.example.ProgettoFineCorso.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private EventoService eventoService;

    @GetMapping("/prenota/{id}")
    public String mostraFormPrenotazione(@PathVariable("id") Long id, Model model) {
        Evento evento = eventoService.trovaEventoPerId(id);
        int postiDisponibili = evento.getPostiDisponibili(); // Otteniamo il numero di posti disponibili per l'evento
        model.addAttribute("evento", evento);
        model.addAttribute("postiDisponibili", postiDisponibili);
        model.addAttribute("prenotazione", new Prenotazione());
        return "formPrenotazione";
    }

    @PostMapping("/prenota/{id}")
    public String salvaPrenotazione(@PathVariable("id") Long id, @ModelAttribute("prenotazione") Prenotazione prenotazione) {
        Evento evento = eventoService.trovaEventoPerId(id);
        if (evento.getPostiDisponibili() > 0) {
            prenotazione.setEvento(evento);
            prenotazioneService.salvaPrenotazione(prenotazione);
            evento.setPostiDisponibili(evento.getPostiDisponibili() - 1);
            eventoService.salvaEvento(evento);
            return "redirect:/eventi";
        } else {
            return "redirect:/prenotazioni/prenota/" + id + "?error=postiEsauriti";
        }
    }

    // Altri metodi del controller...
}
