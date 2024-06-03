package com.example.ProgettoFineCorso.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Date data;
    private String luogo;
    private int postiDisponibili; // Aggiungiamo il campo per i posti disponibili

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private Set<Prenotazione> prenotazioni = new HashSet<>();

    // Costruttori, Getter e Setter methods

    public Evento() {
    }

    public Evento(String nome, Date data, String luogo, int postiDisponibili) {
        this.nome = nome;
        this.data = data;
        this.luogo = luogo;
        this.postiDisponibili = postiDisponibili;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public int getPostiDisponibili() {
        return postiDisponibili;
    }

    public void setPostiDisponibili(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
    }

    public Set<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }
}
