package com.project.demo.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.demo.entity.Autor;
import com.project.demo.entity.CategoriaDeObra;
import com.project.demo.entity.DisponibilidadDeObra;
import com.project.demo.entity.DisponibilidadDeUsuario;
import com.project.demo.entity.EstadoSesion;
import com.project.demo.entity.Obra;
import com.project.demo.entity.TipoDeObra;
import com.project.demo.entity.Ventas;
import com.project.demo.security.entity.Usuario;
import com.project.demo.security.service.UsuarioService;
import com.project.demo.service.AutorService;
import com.project.demo.service.CategoriaDeObraService;
import com.project.demo.service.DisponibilidadDeObraService;
import com.project.demo.service.DisponibilidadDeUsuarioService;
import com.project.demo.service.EstadoSesionService;
import com.project.demo.service.ObraService;
import com.project.demo.service.TipoDeObraService;
import com.project.demo.service.VentasService;

/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateObra implements CommandLineRunner {

	@Autowired
	ObraService obraService;
	@Autowired
	AutorService autorService;
	@Autowired
	CategoriaDeObraService categoriaService;
	@Autowired
	TipoDeObraService tipoService;
	@Autowired
	DisponibilidadDeObraService disponibilidadService;
	@Autowired
	VentasService ventasService;
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	EstadoSesionService estadoService;
	@Autowired
	DisponibilidadDeUsuarioService disponiblidadUsuarioService;
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Override
    public void run(String... args) throws Exception {
		
		TipoDeObra pintura = new TipoDeObra("Pintura");
		TipoDeObra escultura = new TipoDeObra("Escultura");
		tipoService.save(pintura);
		tipoService.save(escultura);
		
		CategoriaDeObra surrealismo = new CategoriaDeObra("Surrealismo");
		CategoriaDeObra impresionismo = new CategoriaDeObra("Impresionismo");
		categoriaService.save(surrealismo);
		categoriaService.save(impresionismo);
		
		DisponibilidadDeObra disponible = new DisponibilidadDeObra("Disponible");
		DisponibilidadDeObra aprobacion = new DisponibilidadDeObra("Aprobacion");
		DisponibilidadDeObra vendida = new DisponibilidadDeObra("Vendida");
		DisponibilidadDeObra enEspera = new DisponibilidadDeObra("En Espera");
		disponibilidadService.save(disponible);
		disponibilidadService.save(aprobacion);
		disponibilidadService.save(vendida);
		disponibilidadService.save(enEspera);
		
		EstadoSesion conectado = new EstadoSesion("Conectado");
		EstadoSesion desconectado = new EstadoSesion("Desconectado");
		estadoService.save(conectado);
		estadoService.save(desconectado);
		
		DisponibilidadDeUsuario habilitado = new DisponibilidadDeUsuario("Habilitado");
		DisponibilidadDeUsuario inhabilitado = new DisponibilidadDeUsuario("Inhabilitado");
		disponiblidadUsuarioService.save(habilitado);
		disponiblidadUsuarioService.save(inhabilitado);
		
		Obra obra = new Obra("La noche estrellada", "Primer Ejemplo", "no hay", 150000, 
				categoriaService.getOne(1).get(), tipoService.getOne(1).get(), disponibilidadService.getOne(1).get());
		
		obraService.save(obra);
		
		Obra obra1 = new Obra("Lirios", "Primer Ejemplo venta", "no hay", 150000, 
				categoriaService.getOne(1).get(), tipoService.getOne(1).get(), disponibilidadService.getOne(3).get());
		
		obraService.save(obra1);
		
		Autor autor = new Autor("Vincent van Gogh");
		autorService.save(autor);
		
		Set<Autor> autores = new HashSet<>();
		Set<Obra> obras = new HashSet<>();
		
		Obra obra2 = obraService.getOne(1).get();
		Obra obra3 = obraService.getOne(2).get();
		Autor autor2 = autorService.getOne(1).get();
		
		autores.add(autor2);
		obras.add(obra2);
		obras.add(obra3);
		
		obra2.setAutores(autores);
		obra3.setAutores(autores);
		autor2.setObras(obras);
		
		obraService.save(obra2);
		obraService.save(obra3);
		autorService.save(autor2);
		
		Usuario usuario = new Usuario("user", "user", "u@u.u", passwordEncoder.encode("user")/*, 
				estadoService.getOne(1).get(), disponiblidadUsuarioService.getOne(1).get()*/);
		usuarioService.save(usuario);
		
		Ventas venta = new Ventas(obra3.getValor() + 100000, new Date());
		ventasService.save(venta);
		
		
		Ventas venta2 = ventasService.getOne(1).get();
		Set<Obra> obrasVenta = new HashSet<>();
		obrasVenta.add(obraService.getOne(2).get());
		venta2.setObra(obrasVenta);
		venta2.setUsuario(usuario);
		
		ventasService.save(venta2);
		
		
    }
}
