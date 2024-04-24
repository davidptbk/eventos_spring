package com.riwi.registroeventos.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.registroeventos.entities.Evento;
import com.riwi.registroeventos.repositories.EventoRepository;
import com.riwi.registroeventos.services.abstract_service.IEventoService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EventoService implements IEventoService{
    @Autowired
    private final EventoRepository objEventoRepository;

    @Override
    public Evento save(Evento objEvento) {
        return this.objEventoRepository.save(objEvento);
    }

    @Override
    public Page<Evento> getAll(int page, int size) {
        if (page<0) {
            page=0;
        }
        Pageable objPageable = PageRequest.of(page, size);
        return this.objEventoRepository.findAll(objPageable);
    }

    @Override
    public Evento getById(String id) {
        return this.objEventoRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
        Evento evento = this.objEventoRepository.findById(id).orElseThrow();

        this.objEventoRepository.delete(evento);
    }

    @Override
    public Evento update(Evento objEvento) {
        return this.objEventoRepository.save(objEvento);
    }
    
}
