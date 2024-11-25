package com.reserva.unipamplona.reserva.unipamplona.repositories;

import com.reserva.unipamplona.reserva.unipamplona.entities.Reserva;
import com.reserva.unipamplona.reserva.unipamplona.tdo.ReservaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    // Verificar reserva existente
    boolean existsByZonaIdAndFechaAndHora(int zonaId, LocalDate fecha, LocalTime hora);
    
    List<Reserva> findByUsuarioCedula(String usuarioCedula);
    
 // Consulta JPQL corregida basada en tu SQL
    @Query("SELECT new com.reserva.unipamplona.reserva.unipamplona.tdo.ReservaDTO(" +
           "u.cedula, " +
           "z.nombre, " +
           "e.descripcion, " +
           "r.fecha, " +
           "r.hora) " +
           "FROM Reserva r " +
           "INNER JOIN r.usuario u " +
           "INNER JOIN r.zona z " +
           "INNER JOIN r.estado e")
    List<ReservaDTO> findReservasEnriquecidasByUsuarioCedula();

    // Versión con filtro por cédula
    @Query("SELECT new com.reserva.unipamplona.reserva.unipamplona.tdo.ReservaDTO(" +
           "u.cedula, " +
           "z.nombre, " +
           "e.descripcion, " +
           "r.fecha, " +
           "r.hora) " +
           "FROM Reserva r " +
           "INNER JOIN r.usuario u " +
           "INNER JOIN r.zona z " +
           "INNER JOIN r.estado e " +
           "WHERE u.cedula = :cedula")
    List<ReservaDTO> findReservasEnriquecidasByUsuarioCedula(@Param("cedula") String cedula);
    
    @Modifying
    @Query("UPDATE Reserva r SET r.estadoId = 4 WHERE r.fecha < :fechaActual AND r.estadoId != 4")
    void actualizarReservasFinalizadas(@Param("fechaActual") LocalDate fechaActual);

}