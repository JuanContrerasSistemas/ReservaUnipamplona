package com.reserva.unipamplona.reserva.unipamplona.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.reserva.unipamplona.reserva.unipamplona.repositories.ReservaRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservaService {
	@Autowired
    private ReservaRepository reservaRepository;

    @Transactional
    @Scheduled(cron = "0 0 0 * * ?") // Se ejecuta todos los días a la medianoche
    public void actualizarEstadosReservas() {
        LocalDate fechaActual = LocalDate.now();

        // Consulta para actualizar los estados de las reservas
        reservaRepository.actualizarReservasFinalizadas(fechaActual);

        System.out.println("Se han actualizado las reservas finalizadas.");
    }

}
