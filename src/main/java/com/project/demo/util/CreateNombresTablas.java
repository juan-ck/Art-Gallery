package com.project.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.demo.entity.NombreTablas;
import com.project.demo.service.NombreTablasService;

/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateNombresTablas implements CommandLineRunner {

	@Autowired
	NombreTablasService service;
	
	@Override
    public void run(String... args) throws Exception {
		NombreTablas usuario = new NombreTablas("Usuario");
		NombreTablas rol = new NombreTablas("Rol");
		service.save(usuario);
		service.save(rol);
        
    }
}
