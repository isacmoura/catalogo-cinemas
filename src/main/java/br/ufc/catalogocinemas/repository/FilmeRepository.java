package br.ufc.catalogocinemas.repository;

import br.ufc.catalogocinemas.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
}
