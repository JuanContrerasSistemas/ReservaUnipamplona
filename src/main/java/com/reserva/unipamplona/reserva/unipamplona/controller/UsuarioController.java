package com.reserva.unipamplona.reserva.unipamplona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reserva.unipamplona.reserva.unipamplona.Services.UsuarioService;
import com.reserva.unipamplona.reserva.unipamplona.model.Usuario;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/registrar")
	public ResponseEntity<String> registrarUsuario(
			@RequestParam @NotNull @NotEmpty String nombre,
			@RequestParam @NotNull @NotEmpty String cedula,
			@RequestParam @NotNull @NotEmpty String telefono,
			@RequestParam @NotNull @NotEmpty String email,
			@RequestParam @NotNull @NotEmpty String password) {

		try {
			// Crear un nuevo objeto Usuario
			Usuario usuario = new Usuario();
			usuario.setCedula(cedula);
			usuario.setNombreCompleto(nombre);
			usuario.setTelefono(telefono);
			usuario.setEmail(email);
			usuario.setContrasena(password);

			// Establecer fecha de registro
			usuario.setFechaRegistro(LocalDateTime.now()); // Usa la fecha y hora actuales

			// Establecer valores para fkrol y fkestado (puedes definirlos según tu lógica)
			usuario.setFkrol("rol_default"); // Aquí puedes usar valores predeterminados o proporcionados por el usuario
			usuario.setFkestado("activo"); // Lo mismo para el estado

			// Guardar usuario en la base de datos
			usuarioService.guardarUsuario(usuario);

			// Retornar respuesta estructurada
			return new ResponseEntity<>("Usuario registrado con éxito: " + nombre, HttpStatus.CREATED);
		} catch (Exception e) {
			// Captura cualquier excepción que ocurra durante el proceso
			return new ResponseEntity<>("Error al registrar el usuario. Intenta de nuevo. Error: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/login")
	public ResponseEntity<String> login(
			@RequestParam @NotNull @NotEmpty String email,
			@RequestParam @NotNull @NotEmpty String contrasena) {

		boolean isAuthenticated = usuarioService.autenticarUsuario(email, contrasena);
		if (isAuthenticated) {
			return ResponseEntity.ok("Inicio de sesión exitoso");
		} else {
			return ResponseEntity.status(401).body("Credenciales inválidas");
		}
	}

}
