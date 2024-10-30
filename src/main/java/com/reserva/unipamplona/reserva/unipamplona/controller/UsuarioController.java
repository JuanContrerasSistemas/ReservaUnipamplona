package com.reserva.unipamplona.reserva.unipamplona.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")

public class UsuarioController {

	// empoin para hacer el delete en el postman

	@DeleteMapping("")
	public String elimianarUsuario(@RequestParam("cedula") int cedula){
		return "Se elimino el usuario con la cedula : " + cedula ;
	}
	

	@PostMapping("/registrar")
	public String registrarUsuario(@RequestParam("nombre") String nombre, @RequestParam("cedula") String cedula,
			@RequestParam("telefono") String telefono, @RequestParam("email") String email,
			@RequestParam("password") String password) {

		// Simulación de registro de usuario
		return "Usuario registrado con éxito: " + nombre;
	}

}

