package com.reserva.unipamplona.reserva.unipamplona.controllers;

import com.reserva.unipamplona.reserva.unipamplona.entities.*;
import com.reserva.unipamplona.reserva.unipamplona.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "*")
public class EstadosController {

    @Autowired
    private EstadosRepository estadoRepository;

    // Obtener todos los estados
    @GetMapping
    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }

    // Obtener un estado por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Long id) {
        return estadoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo estado
    @PostMapping
    public Estado createEstado(@RequestBody Estado estado) {
        return estadoRepository.save(estado);
    }

    // Actualizar un estado
    @PutMapping("/{id}")
    public ResponseEntity<Estado> updateEstado(@PathVariable Long id, @RequestBody Estado estado) {
        return estadoRepository.findById(id)
                .map(existingEstado -> {
                    estado.setId(id);
                    return ResponseEntity.ok(estadoRepository.save(estado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un estado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Long id) {
        return estadoRepository.findById(id)
                .map(estado -> {
                    estadoRepository.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}




