package com.project.demo.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

public class AutorDto {

	@NotBlank
	private String nombre;
	private Set<String> obras = new HashSet<>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<String> getObras() {
		return obras;
	}

	public void setObras(Set<String> obras) {
		this.obras = obras;
	}
	
	
	
	
}
