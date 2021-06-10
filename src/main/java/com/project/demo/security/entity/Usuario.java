package com.project.demo.security.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.project.demo.entity.DisponibilidadDeUsuario;
import com.project.demo.entity.EstadoSesion;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    /*@NotNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = "usuario_estado_sesion")
    private EstadoSesion estadoSesion;
    //@NotNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = "usuario_disponibilidad")
    private DisponibilidadDeUsuario disponibilidadUsuario;*/

    public Usuario() {
    }

    public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email, @NotNull String password
    		/*,EstadoSesion estadoSesion, DisponibilidadDeUsuario disponibilidadUsuario*/) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        //this.estadoSesion = estadoSesion;
        //this.disponibilidadUsuario = disponibilidadUsuario;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
/*
	public EstadoSesion getEstadoSesion() {
		return estadoSesion;
	}

	public void setEstadoSesion(EstadoSesion estadoSesion) {
		this.estadoSesion = estadoSesion;
	}

	public DisponibilidadDeUsuario getDisponibilidadUsuario() {
		return disponibilidadUsuario;
	}

	public void setDisponibilidadUsuario(DisponibilidadDeUsuario disponibilidadUsuario) {
		this.disponibilidadUsuario = disponibilidadUsuario;
	}
    */
}
