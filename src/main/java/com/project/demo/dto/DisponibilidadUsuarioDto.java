package com.project.demo.dto;

import javax.validation.constraints.NotBlank;

public class DisponibilidadUsuarioDto {

	@NotBlank
    private String nombre;
	
	public DisponibilidadUsuarioDto() {
    }

    public DisponibilidadUsuarioDto(@NotBlank String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
