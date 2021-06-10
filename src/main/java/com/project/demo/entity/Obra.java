package com.project.demo.entity;

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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Obra {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private int valor;
    
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "obra_autor", joinColumns = @JoinColumn(name = "obra_id"),
    inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private Set<Autor> autores = new HashSet<>();
    
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = "obra_categoria")
    private CategoriaDeObra categoria;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = "obra_tipo")
    private TipoDeObra tipo;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = "obra_disponibilidad")
    private DisponibilidadDeObra disponibilidad;
    //ManyToOne
    //@JoinColumn(name = "venta_id")
    //private Ventas venta;
    
	public Obra() {
		super();
	}
	
	public Obra(String nombre, String descripcion, String imagen, int valor,
			@NotNull CategoriaDeObra categoria, @NotNull TipoDeObra tipo,
			@NotNull DisponibilidadDeObra disponibilidad) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.valor = valor;
		this.categoria = categoria;
		this.tipo = tipo;
		this.disponibilidad = disponibilidad;
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

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
