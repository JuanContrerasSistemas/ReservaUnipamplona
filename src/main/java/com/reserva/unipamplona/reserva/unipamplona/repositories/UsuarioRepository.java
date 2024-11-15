package com.reserva.unipamplona.reserva.unipamplona.repositories;

import com.reserva.unipamplona.reserva.unipamplona.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    boolean existsByCedula(String cedula);
    boolean existsByEmail(String email);
    Usuario findByEmail(String email);
}
