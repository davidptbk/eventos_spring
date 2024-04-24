package com.riwi.registroeventos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.registroeventos.entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, String>{
    public List<Evento> findByName(String name);
    
}
