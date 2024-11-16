package com.reserva.unipamplona.reserva.unipamplona.entities;

import jakarta.persistence.*;
//import lombok.Data;

@Entity
@Table(name = "estados")
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
}

