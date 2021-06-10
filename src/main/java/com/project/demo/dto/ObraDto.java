package com.project.demo.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.project.demo.entity.CategoriaDeObra;
import com.project.demo.entity.DisponibilidadDeObra;
import com.project.demo.entity.TipoDeObra;

public class ObraDto {

	@NotBlank
    private String nombre;
	private String descripcion;
	@NotBlank
    private String imagen;
	@NotNull
	private int valor;

	private Set<String> autores = new HashSet<>();
	private CategoriaDeObra categoria;
	private TipoDeObra tipo;
	private DisponibilidadDeObra disponibilidad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Set<String> getAutores() {
		return autores;
	}
	public void setAutores(Set<String> autores) {
		this.autores = autores;
	}
	public CategoriaDeObra getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDeObra categoria) {
		this.categoria = categoria;
	}
	public TipoDeObra getTipo() {
		return tipo;
	}
	public void setTipo(TipoDeObra tipo) {
		this.tipo = tipo;
	}
	public DisponibilidadDeObra getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(DisponibilidadDeObra disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
}
