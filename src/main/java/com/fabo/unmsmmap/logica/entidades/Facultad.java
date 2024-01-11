package com.fabo.unmsmmap.logica.entidades;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Facultad extends Establecimiento {
	String codigo, telefonoContacto, correoContacto;

	public Facultad(String alias, String nombre, String descripcion, String logo, ArrayList<String> imagenes,
			String codigo, String telefonoContacto, String correoContacto) {
		super(alias, nombre, descripcion, logo, imagenes);
		this.codigo = codigo;
		this.telefonoContacto = telefonoContacto;
		this.correoContacto = correoContacto;
	}

	
}