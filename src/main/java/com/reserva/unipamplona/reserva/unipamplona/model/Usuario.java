package com.reserva.unipamplona.reserva.unipamplona.model;

public class Usuario {
	private String cedula;
    private String nombreCompleto;
    private String telefono;
    private String email;
    private String contrasena;

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

}
