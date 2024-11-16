package com.reserva.unipamplona.reserva.unipamplona.repositories;

import com.reserva.unipamplona.reserva.unipamplona.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadosRepository extends JpaRepository<Estado, Long> {
}

