package com.riwi.registroeventos.controllers;

import java.time.LocalDate;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.registroeventos.entities.Evento;
import com.riwi.registroeventos.services.abstract_service.IEventoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/eventos")
@AllArgsConstructor
public class EventoController {
    @Autowired
    private final IEventoService objIEventoService;

    @GetMapping
    public ResponseEntity<Page<Evento>> getAllPaginate(){
        return ResponseEntity.ok(this.objIEventoService.getAll(1,2));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Evento> get(@PathVariable String id){
        return ResponseEntity.ok(this.objIEventoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Evento> insert(@RequestBody Evento objEvento){
        int capacity = objEvento.getCapacity();
        if ( capacity <=0) {
            return null;
        }

        // Date dateNow = LocalDate.now();
        // LocalDate date = objEvento.getDate();
        // if ( date equals(dateNow) ) {
            
        // }
        return ResponseEntity.ok(this.objIEventoService.save(objEvento));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Evento> update(
        @RequestBody Evento objEvento,
        @PathVariable String id
    ){
        objEvento.setId(id);
        return ResponseEntity.ok(this.objIEventoService.update(objEvento));
        
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.objIEventoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
