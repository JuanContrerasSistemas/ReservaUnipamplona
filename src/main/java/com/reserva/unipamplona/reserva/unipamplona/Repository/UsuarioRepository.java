package com.reserva.unipamplona.reserva.unipamplona.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.reserva.unipamplona.reserva.unipamplona.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
  // Métodos personalizados si es necesario
  boolean existsByCedula(String cedula);

  Usuario findByEmail(String email); // Buscar por email
}