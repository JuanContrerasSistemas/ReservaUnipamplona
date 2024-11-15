package com.reserva.unipamplona.reserva.unipamplona.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.reserva.unipamplona.reserva.unipamplona.entities.*;
import com.reserva.unipamplona.reserva.unipamplona.repositories.*;
import com.reserva.unipamplona.reserva.unipamplona.tdo.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarReserva(@RequestBody ReservaDTO reservaDTO) {
        // Verificar que el usuario existe
        var usuario = usuarioRepository.findById(reservaDTO.getUsuarioCedula());
        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado.");
        }

        // Verificar disponibilidad de la zona en la fecha y hora especificadas
        if (reservaRepository.existsByZonaIdAndFechaAndHora(reservaDTO.getZonaId(), reservaDTO.getFecha(), reservaDTO.getHora())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esta zona ya está reservada en la fecha y hora especificadas.");
        }

        // Crear y guardar la nueva reserva
        Reserva nuevaReserva = new Reserva();
        nuevaReserva.setUsuarioCedula(reservaDTO.getUsuarioCedula());
        nuevaReserva.setZonaId(reservaDTO.getZonaId());
        nuevaReserva.setFecha(reservaDTO.getFecha());
        nuevaReserva.setHora(reservaDTO.getHora());
        nuevaReserva.setEstadoId(1); // Estado predeterminado

        reservaRepository.save(nuevaReserva);

        return ResponseEntity.status(HttpStatus.CREATED).body("Reserva registrada exitosamente.");
    }
}
