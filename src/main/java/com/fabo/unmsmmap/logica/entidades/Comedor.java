package com.fabo.unmsmmap.logica.entidades;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Clase que representa un comedor de la universidad
 */
public class Comedor extends Establecimiento {
	// Atributos
	String horarioAtencion;
	String capacidad;

	// Constructores
	public Comedor(String nombre, String descripcion, ImageIcon logo, ArrayList<ImageIcon> ims, JLabel nodo,
			String horAtencion, String capacidad) {
		super(nombre, descripcion, logo, ims, nodo);
		horarioAtencion = horAtencion;
		this.capacidad = capacidad;
	}

	public Comedor(String nombre, String descripcion, String horarioAtencion, String capacidad) {
		super(nombre, descripcion);
		this.horarioAtencion = horarioAtencion;
		this.capacidad = capacidad;
	}

	// Métodos set y get
	public String getHorarioAtencion() {
		return horarioAtencion;
	}

	public void setHorarioAtencion(String hAten) {
		this.horarioAtencion = hAten;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String cap) {
		this.capacidad = cap;
	}
}
