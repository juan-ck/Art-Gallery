package com.project.demo.dto;

import java.util.Date;

public class AuditoriaDto {

	private Date fecha;

	public AuditoriaDto() {
		super();
	}

	public AuditoriaDto(Date fecha) {
		super();
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
