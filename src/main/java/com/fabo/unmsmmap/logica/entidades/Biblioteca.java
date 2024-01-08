package com.fabo.unmsmmap.logica.entidades;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Clase que representa una biblioteca de la universidad
 */
public class Biblioteca extends Establecimiento {
	// Atributos
	String telefono;
	String horarioAtencion;

	// Constructor
	public Biblioteca(String nombre, String descripcion, ImageIcon logo, ArrayList<ImageIcon> ims, JLabel nodo,
			String telefono, String horAtencion) {
		super(nombre, descripcion, logo, ims, nodo);
		this.telefono = telefono;
		horarioAtencion = horAtencion;
	}

	// Métodos set y get
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getHorarioAtencion() {
		return horarioAtencion;
	}

	public void setHorarioAtencion(String horAtencion) {
		this.horarioAtencion = horAtencion;
	}
}
