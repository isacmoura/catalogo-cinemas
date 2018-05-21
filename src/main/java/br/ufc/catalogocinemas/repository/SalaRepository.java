package br.ufc.catalogocinemas.repository;

import br.ufc.catalogocinemas.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

    Sala findByNome(String nome);

}