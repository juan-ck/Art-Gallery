package com.project.demo.dto;

import javax.validation.constraints.NotBlank;

public class EstadoSesionDto {

	@NotBlank
    private String nombre;
	
	public EstadoSesionDto() {
    }

    public EstadoSesionDto(@NotBlank String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
