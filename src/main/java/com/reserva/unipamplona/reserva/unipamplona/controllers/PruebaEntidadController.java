package com.reserva.unipamplona.reserva.unipamplona.controllers;


import com.reserva.unipamplona.reserva.unipamplona.entities.PruebaEntidad;
import com.reserva.unipamplona.reserva.unipamplona.repositories.PruebaEntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PruebaEntidadController {

    @Autowired
    private PruebaEntidadRepository pruebaEntidadRepository;

    // Endpoint para agregar una nueva entidad
    @GetMapping("/agregar")
    public PruebaEntidad agregarEntidad(@RequestParam String nombre) {
        PruebaEntidad entidad = new PruebaEntidad(nombre);
        return pruebaEntidadRepository.save(entidad);
    }

    // Endpoint para listar todas las entidades
    @GetMapping("/listar")
    public List<PruebaEntidad> listarEntidades() {
        return pruebaEntidadRepository.findAll();
    }
}