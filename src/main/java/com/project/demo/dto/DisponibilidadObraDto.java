package com.project.demo.dto;

import javax.validation.constraints.NotBlank;

public class DisponibilidadObraDto {

	@NotBlank
    private String nombre;
	
	public DisponibilidadObraDto() {
    }

    public DisponibilidadObraDto(@NotBlank String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
