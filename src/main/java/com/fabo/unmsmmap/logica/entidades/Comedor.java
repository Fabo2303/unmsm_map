package com.fabo.unmsmmap.logica.entidades;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comedor extends Establecimiento {
	String horarioAtencion, capacidad;

	public Comedor(String alias, String nombre, String descripcion, String logo, ArrayList<String> imagenes,
			String horarioAtencion, String capacidad) {
		super(alias, nombre, descripcion, logo, imagenes);
		this.horarioAtencion = horarioAtencion;
		this.capacidad = capacidad;
	}

	
}
