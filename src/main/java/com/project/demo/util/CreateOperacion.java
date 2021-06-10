package com.project.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.demo.entity.Operacion;
import com.project.demo.service.OperacionService;

/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateOperacion implements CommandLineRunner {

	@Autowired
	OperacionService service;
	
	@Override
    public void run(String... args) throws Exception {
		Operacion insert = new Operacion("Insert");
		Operacion update = new Operacion("Update");
		Operacion delete = new Operacion("Delete");
		service.save(insert);
		service.save(update);
		service.save(delete);
        
    }
}
