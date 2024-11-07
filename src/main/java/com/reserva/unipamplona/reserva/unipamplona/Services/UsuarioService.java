package com.reserva.unipamplona.reserva.unipamplona.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reserva.unipamplona.reserva.unipamplona.model.Usuario;
import com.reserva.unipamplona.reserva.unipamplona.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para guardar un nuevo usuario en la base de datos
    public void guardarUsuario(Usuario usuario) {
        if (!usuarioRepository.existsByCedula(usuario.getCedula())) {
            usuarioRepository.save(usuario); // Guarda el usuario en la base de datos
        } else {
            throw new RuntimeException("El usuario con esa cédula ya está registrado.");
        }
    }

    public boolean autenticarUsuario(String email, String contrasena) {
        // Buscar usuario por email
        Usuario usuario = usuarioRepository.findByEmail(email);

        // Verificar si el usuario existe y la contraseña coincide
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return true;
        }
        return false;
    }
}
