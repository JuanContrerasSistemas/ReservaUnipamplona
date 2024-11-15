package com.reserva.unipamplona.reserva.unipamplona.tdo;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {
    private String usuarioCedula;
    private int zonaId;
    private LocalDate fecha;
    private LocalTime hora;

    // Getters y setters
    public String getUsuarioCedula() {
        return usuarioCedula;
    }

    public void setUsuarioCedula(String usuarioCedula) {
        this.usuarioCedula = usuarioCedula;
    }

    public int getZonaId() {
        return zonaId;
    }

    public void setZonaId(int zonaId) {
        this.zonaId = zonaId;
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
