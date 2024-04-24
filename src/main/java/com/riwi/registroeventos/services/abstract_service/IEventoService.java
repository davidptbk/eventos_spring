package com.riwi.registroeventos.services.abstract_service;



import org.springframework.data.domain.Page;

import com.riwi.registroeventos.entities.Evento;

public interface IEventoService {
    public Evento save(Evento objEvento);
    public Page<Evento> getAll(int page, int size);
    public Evento getById(String id);
    public void delete(String id);
    public Evento update(Evento objEvento);
}
