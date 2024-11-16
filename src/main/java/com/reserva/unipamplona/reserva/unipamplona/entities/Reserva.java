package com.reserva.unipamplona.reserva.unipamplona.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas", uniqueConstraints = @UniqueConstraint(columnNames = { "zona_id", "fecha", "hora" }))
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "usuario_cedula", nullable = false)
	private String usuarioCedula;

	@ManyToOne
	@JoinColumn(name = "usuario_cedula", insertable = false, updatable = false)
	private Usuario usuario;

	@Column(name = "zona_id", nullable = false)
	private int zonaId;

	@ManyToOne
	@JoinColumn(name = "zona_id", insertable = false, updatable = false)
	private ZonaRecreativa zona;

	@Column(name = "estado_id", nullable = false)
	private int estadoId;

	@ManyToOne
	@JoinColumn(name = "estado_id", insertable = false, updatable = false)
	private Estado estado;

	@Column(nullable = false)
	private LocalDate fecha;

	@Column(nullable = false)
	private LocalTime hora;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuarioCedula() {
		return usuarioCedula;
	}

	public void setUsuarioCedula(String usuarioCedula) {
		this.usuarioCedula = usuarioCedula;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getZonaId() {
		return zonaId;
	}

	public void setZonaId(int zonaId) {
		this.zonaId = zonaId;
	}

	public ZonaRecreativa getZona() {
		return zona;
	}

	public void setZona(ZonaRecreativa zona) {
		this.zona = zona;
	}

	public int getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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
