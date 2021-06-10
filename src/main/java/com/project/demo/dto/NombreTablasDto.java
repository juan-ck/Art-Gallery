package com.project.demo.dto;

import javax.validation.constraints.NotBlank;

public class NombreTablasDto {

	@NotBlank
    private String nombre;
	
	public NombreTablasDto() {
    }

    public NombreTablasDto(@NotBlank String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
