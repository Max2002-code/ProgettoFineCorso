package com.example.ProgettoFineCorso.controller;

import com.example.ProgettoFineCorso.model.Evento;
import com.example.ProgettoFineCorso.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/eventi")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // Metodo per visualizzare il modulo per creare un nuovo evento
    @GetMapping("/crea")
    public String mostraModuloCreazioneEvento(Model model) {
        model.addAttribute("evento", new Evento());
        return "crea_evento";
    }

    // Metodo per gestire la creazione di un nuovo evento
    @PostMapping("/crea")
    public String creaEvento(@ModelAttribute("evento") Evento evento) {
        eventoService.salvaEvento(evento);
        return "redirect:/eventi";
    }

    // Metodo per visualizzare il modulo per modificare un evento esistente
    @GetMapping("/modifica/{id}")
    public String mostraModuloModificaEvento(@PathVariable("id") Long id, Model model) {
        Evento evento = eventoService.trovaEventoPerId(id);
        model.addAttribute("evento", evento);
        return "modifica_evento";
    }

    // Metodo per gestire la modifica di un evento esistente
    @PostMapping("/modifica/{id}")
    public String modificaEvento(@PathVariable("id") Long id, @ModelAttribute("evento") Evento evento) {
        evento.setId(id);
        eventoService.salvaEvento(evento);
        return "redirect:/eventi";
    }

    // Metodo per eliminare un evento
    @GetMapping("/elimina/{id}")
    public String eliminaEvento(@PathVariable("id") Long id) {
        eventoService.eliminaEvento(id);
        return "redirect:/eventi";
    }
}
