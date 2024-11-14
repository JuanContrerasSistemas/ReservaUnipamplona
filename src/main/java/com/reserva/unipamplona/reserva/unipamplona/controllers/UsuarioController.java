package com.reserva.unipamplona.reserva.unipamplona.controllers;

import com.reserva.unipamplona.reserva.unipamplona.entities.Usuario;

import com.reserva.unipamplona.reserva.unipamplona.repositories.UsuarioRepository;

import com.reserva.unipamplona.reserva.unipamplona.tdo.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        // Verificar si ya existe un usuario con la misma cedula o email
        if (usuarioRepository.existsByCedula(usuario.getCedula())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("La cédula ya está registrada. Intente con otra.");
        }
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El email ya está registrado. Intente con otro.");
        }

        // Si no existe, guarda el nuevo usuario
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }
    

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody UsuarioLoginDTO loginDTO) {
        // Buscar usuario por email
        Usuario usuario = usuarioRepository.findByEmail(loginDTO.getEmail());

        if (usuario != null && usuario.getPassword().equals(loginDTO.getPassword())) {
            return ResponseEntity.ok("Inicio de sesión exitoso.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email o contraseña incorrectos.");
        }
        
    }
    
    @GetMapping("/detalle")
    public ResponseEntity<?> obtenerUsuarioPorEmail(@RequestParam String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null) {
            return ResponseEntity.ok(usuario); // Devuelve los detalles completos del usuario
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }

  
}