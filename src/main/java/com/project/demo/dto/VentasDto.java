package com.project.demo.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.project.demo.entity.Obra;
import com.project.demo.security.entity.Usuario;

public class VentasDto {
	
	private int valor;
	private Date fecha;
	private Set<String> obra = new HashSet<>();
	private Usuario usuario;
	
	public Set<String> getObra() {
		return obra;
	}
	public void setObra(Set<String> obra) {
		this.obra = obra;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
