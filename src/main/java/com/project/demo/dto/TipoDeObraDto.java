package com.project.demo.dto;

import javax.validation.constraints.NotBlank;

public class TipoDeObraDto {

	@NotBlank
    private String nombre;
	
	public TipoDeObraDto() {
    }

    public TipoDeObraDto(@NotBlank String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
