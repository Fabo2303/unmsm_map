package com.fabo.unmsmmap.logica.entidades;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Biblioteca extends Establecimiento {
	String telefono, horarioAtencion;

	public Biblioteca(String alias, String nombre, String descripcion, String logo, ArrayList<String> imagenes,String telefono, String horarioAtencion) {
		super(alias, nombre, descripcion, logo, imagenes);
		this.telefono = telefono;
		this.horarioAtencion = horarioAtencion;
	}
}
