package com.reserva.unipamplona.reserva.unipamplona.tdo;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {
    private String usuarioCedula;
    private String zonaNombre; // Nombre de la zona
    private String estadoDescripcion; // Descripción del estado
    private LocalDate fecha;
    private LocalTime hora;
   

	// Constructor completo para consultas personalizadas
    public ReservaDTO(String usuarioCedula, String zonaNombre, String estadoDescripcion, LocalDate fecha, LocalTime hora) {
        this.usuarioCedula = usuarioCedula;
        this.zonaNombre = zonaNombre;
        this.estadoDescripcion = estadoDescripcion;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Getters y setters
    public String getUsuarioCedula() {
        return usuarioCedula;
    }

    public void setUsuarioCedula(String usuarioCedula) {
        this.usuarioCedula = usuarioCedula;
    }

    public String getZonaNombre() {
        return zonaNombre;
    }

    public void setZonaNombre(String zonaNombre) {
        this.zonaNombre = zonaNombre;
    }

    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String estadoDescripcion) {
        this.estadoDescripcion = estadoDescripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}


