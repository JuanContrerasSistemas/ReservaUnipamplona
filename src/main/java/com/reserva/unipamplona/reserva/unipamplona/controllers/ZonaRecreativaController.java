package com.reserva.unipamplona.reserva.unipamplona.controllers;

import com.reserva.unipamplona.reserva.unipamplona.entities.*;
import com.reserva.unipamplona.reserva.unipamplona.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zonas")
public class ZonaRecreativaController {

    @Autowired
    private ZonaRecreativaRepository zonaRecreativaRepository;

    // Método para obtener todas las zonas recreativas
    @GetMapping("/todas")
    public ResponseEntity<List<ZonaRecreativa>> obtenerTodasZonas() {
        List<ZonaRecreativa> zonas = zonaRecreativaRepository.findAll();
        return ResponseEntity.ok(zonas);
    }
}