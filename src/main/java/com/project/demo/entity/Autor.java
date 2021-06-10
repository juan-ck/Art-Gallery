package com.project.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Autor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Obra> obras = new HashSet<>();

	

	public Autor() {
		super();
	}

	public Autor(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
	public Set<Obra> getObras() {
		return obras;
	}

	public void setObras(Set<Obra> obras) {
		this.obras = obras;
	}
}
