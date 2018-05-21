package br.ufc.catalogocinemas.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nome;

    private String sinopse;
    private int duracao;

    @ManyToMany
            (cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            })
    @JoinTable(name = "filme_atores",
            joinColumns = @JoinColumn(name="filme_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id"))
    private List<Ator> atores;

    @ManyToMany
            (cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
            })
    @JoinTable(name = "filme_diretores",
            joinColumns = @JoinColumn(name="filme_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diretor_id", referencedColumnName = "id"))
    private List<Diretor> diretores;

    @OneToOne
    private Genero genero;

    public Filme() {
    }

    public Filme(String nome, String sinopse, int duracao, Genero genero) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.genero = genero;
        this.atores = new ArrayList<>();
        this.diretores = new ArrayList<>();
    }

    public Filme(String nome, String sinopse, int duracao, List<Ator> atores, List<Diretor> diretores, Genero genero) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.atores = atores;
        this.diretores = diretores;
        this.genero = genero;
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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public boolean adicionarAtor(Ator ator){
        return this.getAtores().add(ator);
    }

    public boolean removerAtor(Ator ator){
        return this.getAtores().remove(ator);
    }

    public List<Diretor> getDiretores() {
        return diretores;
    }

    public boolean adicionarDiretor(Diretor diretor){
        return this.getDiretores().add(diretor);
    }

    public boolean removerDiretor(Diretor diretor){
        return this.getDiretores().remove(diretor);
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filme filme = (Filme) o;

        return id == filme.id;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", duracao=" + duracao +
                ", genero=" + genero +
                '}';
    }
}