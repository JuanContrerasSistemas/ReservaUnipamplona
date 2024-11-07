package com.reserva.unipamplona.reserva.unipamplona.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tmusuarios")
public class Usuario {

    @Id
    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "contraseña") // Si el campo en la base de datos se llama "contraseña"
    private String contrasena;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fkrol")
    private String fkrol; // Asumiendo que fkrol es un campo de tipo String o similar

    @Column(name = "fkestado")
    private String fkestado; // Asumiendo que fkestado es un campo de tipo String o similar

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFkrol() {
        return fkrol;
    }

    public void setFkrol(String fkrol) {
        this.fkrol = fkrol;
    }

    public String getFkestado() {
        return fkestado;
    }

    public void setFkestado(String fkestado) {
        this.fkestado = fkestado;
    }
}
