package com.fabo.unmsmmap.logica.entidades;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Establecimiento implements Serializable {
	private String alias, nombre, descripcion, logo;
	private ArrayList<String> imagenes;
}