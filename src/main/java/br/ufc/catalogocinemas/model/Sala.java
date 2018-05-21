package br.ufc.catalogocinemas.model;

import br.ufc.catalogocinemas.enums.TipoSala;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Sala{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoSala tipo;

    @ManyToOne
    private Cinema cinema;

    @NotNull
    private int capacidade;

    public Sala() {
    }

    public Sala(String nome, TipoSala tipo, Cinema cinema, int capacidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.cinema = cinema;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoSala getTipo() {
        return tipo;
    }

    public void setTipo(TipoSala tipo) {
        this.tipo = tipo;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sala sala = (Sala) o;

        return id == sala.id;
    }

    @Override
    public String toString() {
        Integer idCinema = cinema != null ? cinema.getId() : null;

        return "Sala{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", cinema=" + idCinema+
                ", capacidade=" + capacidade +
                '}';
    }
}