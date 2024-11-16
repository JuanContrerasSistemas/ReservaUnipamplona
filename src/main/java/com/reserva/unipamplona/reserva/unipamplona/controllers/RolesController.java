package com.reserva.unipamplona.reserva.unipamplona.controllers;

import com.reserva.unipamplona.reserva.unipamplona.entities.*;
import com.reserva.unipamplona.reserva.unipamplona.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    // Obtener todos los roles
    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    // Obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRolById(@PathVariable Long id) {
        return rolesRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo rol
    @PostMapping
    public ResponseEntity<Roles> createRol(@RequestBody Roles rol) {
        try {
            Roles nuevoRol = rolesRepository.save(rol);
            return ResponseEntity.ok(nuevoRol);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Actualizar un rol
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRol(@PathVariable Long id, @RequestBody Roles rol) {
        if(rolesRepository.existsById(id)) {
            rol.setId(id);
            return ResponseEntity.ok(rolesRepository.save(rol));
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un rol
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        return rolesRepository.findById(id)
                .map(rol -> {
                    rolesRepository.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}