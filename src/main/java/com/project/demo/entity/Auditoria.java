package com.project.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.project.demo.security.entity.Usuario;

@Entity
public class Auditoria {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@NotNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = "auditoria_usuario")
    private Usuario usuario;
	@NotNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = "auditoria_operacion")
    private Operacion operacion;
	@NotNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = "auditoria_tablas")
    private NombreTablas nombreTablas;
	private Date fecha;
	private String ip;
	public Auditoria() {
		super();
	}
	public Auditoria(@NotNull Usuario usuario, @NotNull Operacion operacion, @NotNull NombreTablas nombreTablas,
			Date fecha, String ip) {
		super();
		this.usuario = usuario;
		this.operacion = operacion;
		this.nombreTablas = nombreTablas;
		this.fecha = fecha;
		this.ip = ip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Operacion getOperacion() {
		return operacion;
	}
	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}
	public NombreTablas getNombreTablas() {
		return nombreTablas;
	}
	public void setNombreTablas(NombreTablas nombreTablas) {
		this.nombreTablas = nombreTablas;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
}
