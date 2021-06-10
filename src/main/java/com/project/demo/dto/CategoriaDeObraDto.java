package com.project.demo.dto;

import javax.validation.constraints.NotBlank;

public class CategoriaDeObraDto {

	@NotBlank
    private String nombre;
	
	public CategoriaDeObraDto() {
    }

    public CategoriaDeObraDto(@NotBlank String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
