package com.projeto.projetoAula.Repository;

import com.projeto.projetoAula.Model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Integer> {


    void delete(Optional<Evento> evento);
}
