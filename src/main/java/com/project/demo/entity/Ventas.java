package com.project.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.project.demo.security.entity.Usuario;

@Entity
public class Ventas {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	//@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "venta_obra", joinColumns = @JoinColumn(name = "venta_id"),
    inverseJoinColumns = @JoinColumn(name = "obra_id"))
	private Set<Obra> obra = new HashSet<>();
	@NotNull
	private int valor;
	@NotNull
	private Date fecha;
	//@NotNull
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = "ventas_usuario")
	private Usuario usuario;
	public Ventas() {
		super();
	}
	public Ventas(@NotNull int valor, @NotNull Date fecha) {
		super();
		this.valor = valor;
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Obra> getObra() {
		return obra;
	}
	public void setObra(Set<Obra> obra) {
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
