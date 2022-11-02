package com.projeto.projetoAula.Service;

import com.projeto.projetoAula.Model.Evento;
import com.projeto.projetoAula.Repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public void salvarEvento(Evento evento){
        eventoRepository.save(evento);
    }

    public Optional<Evento> buscarEventoId (Integer id){
         return eventoRepository.findById(id);
    }


    public boolean excluirEvento(Integer id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        if(evento != null){
            eventoRepository.delete(evento);
            return true;
        }
        return false;
    }
    }





