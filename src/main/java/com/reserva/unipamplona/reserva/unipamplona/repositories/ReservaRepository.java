package com.reserva.unipamplona.reserva.unipamplona.repositories;

import com.reserva.unipamplona.reserva.unipamplona.entities.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    // Consulta para verificar si ya existe una reserva en la misma zona, fecha y hora
    boolean existsByZonaIdAndFechaAndHora(int zonaId, LocalDate fecha, LocalTime hora);
    
    List<Reserva> findByUsuarioCedula(String usuarioCedula);
}