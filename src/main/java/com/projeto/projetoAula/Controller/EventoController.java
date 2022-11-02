package com.projeto.projetoAula.Controller;


import com.projeto.projetoAula.Model.Evento;
import com.projeto.projetoAula.Repository.EventoRepository;
import com.projeto.projetoAula.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/evento")
class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EventoService eventoService;

    @GetMapping("/{id}")
    public Optional<Evento> getEvento(@PathVariable Integer id) {

        return eventoService.buscarEventoId(id);
    }


    @PostMapping
    public String salvarEventos (@RequestBody Evento evento) {
        if (evento.getNome() == null || evento.getNome().equals("")) {
            return "o nome do evento é obrigatório";

        }
        if (evento.getId() == null || evento.getId().equals("")) {
            return "Id é obrigatório";
        }

        Optional<Evento> eventoBD = eventoService.buscarEventoId(evento.getId());

        if(eventoBD != null){
            return "Evento já cadastrado";

        }

        eventoService.salvarEvento(evento);
        return "Evento cadastrado com sucesso!";

    }

    @DeleteMapping("/{id}")
    public String excluirEvento(@PathVariable Integer id) {

        boolean excluiu = eventoService.excluirEvento(id);

        if(excluiu){

            return "evento excluído com sucesso!";
        }

        return "Evento não localizado";
    }




}
