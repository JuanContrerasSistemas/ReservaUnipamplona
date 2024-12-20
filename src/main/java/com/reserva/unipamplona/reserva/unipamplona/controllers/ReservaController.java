package com.reserva.unipamplona.reserva.unipamplona.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.reserva.unipamplona.reserva.unipamplona.entities.*;
import com.reserva.unipamplona.reserva.unipamplona.repositories.*;
//import com.reserva.unipamplona.reserva.unipamplona.tdo.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registrar")///////
    public ResponseEntity<?> registrarReserva(@RequestBody Reserva Reserva) {
        // Verificar que el usuario existe
        var usuario = usuarioRepository.findById(Reserva.getUsuarioCedula());
        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado.");
        }

        // Verificar disponibilidad de la zona en la fecha y hora especificadas
        if (reservaRepository.existsByZonaIdAndFechaAndHora(Reserva.getZonaId(), Reserva.getFecha(), Reserva.getHora())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esta zona ya está reservada en la fecha y hora especificadas.");
        }

        // Crear y guardar la nueva reserva
        Reserva nuevaReserva = new Reserva();
        nuevaReserva.setUsuarioCedula(Reserva.getUsuarioCedula());
        nuevaReserva.setZonaId(Reserva.getZonaId());
        nuevaReserva.setFecha(Reserva.getFecha());
        nuevaReserva.setHora(Reserva.getHora());
        nuevaReserva.setEstadoId(1); // Estado predeterminado

        reservaRepository.save(nuevaReserva);

        return ResponseEntity.status(HttpStatus.CREATED).body("Reserva registrada exitosamente.");
    }
    
    /*
     * Original solo consulta normal de la reservas
     * @GetMapping("/usuario/{cedula}")
    public ResponseEntity<?> obtenerReservasPorUsuario(@PathVariable String cedula) {
        try {
            List<Reserva> reservas = reservaRepository.findByUsuarioCedula(cedula);
            if (reservas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron reservas para este usuario.");
            }
            return ResponseEntity.ok(reservas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las reservas: " + e.getMessage());
        }
    }
    */
    
    
    @GetMapping("/usuario/{cedula}")
    public ResponseEntity<?> obtenerReservasPorUsuario(@PathVariable String cedula) {
        try {
            List<Reserva> reservas = reservaRepository.findByUsuarioCedula(cedula);
            if (reservas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron reservas para este usuario.");
            }
            return ResponseEntity.ok(reservas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener las reservas: " + e.getMessage());
        }
    }
}
