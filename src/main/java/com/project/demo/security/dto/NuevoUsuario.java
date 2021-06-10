package com.project.demo.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.project.demo.entity.DisponibilidadDeUsuario;
import com.project.demo.entity.EstadoSesion;

import java.util.HashSet;
import java.util.Set;

public class NuevoUsuario {
    @NotBlank
    private String nombre;
    @NotBlank
    private String nombreUsuario;
    @Email
    private String email;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();
    /*
    private EstadoSesion estadoSesion;
    private DisponibilidadDeUsuario disponibilidadUsuario;
    */

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
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
