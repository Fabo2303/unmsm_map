package com.fabo.unmsmmap.logica.entidades;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Establecimiento implements Serializable {
	// Atributos
	private String nombre, descripcion;
	private ImageIcon logo;
	private ArrayList<ImageIcon> imagenes = new ArrayList<>();
	private JLabel nodo;

	// Constructores
	public Establecimiento(String nombre, String descripcion, ImageIcon logo, ArrayList<ImageIcon> ims,
			JLabel nodo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.logo = logo;
		this.imagenes = ims;
		this.nodo = nodo;
	}

	public Establecimiento() {
		this.nombre = "NA";
		this.descripcion = "NA";
		this.nodo = new JLabel();
	}

	public Establecimiento(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	// Métodos set y get
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ImageIcon getLogo() {
		return this.logo;
	}

	public void setLogo(ImageIcon logo) {
		this.logo = logo;
	}

	public ArrayList<ImageIcon> getImagenes() {
		return this.imagenes;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagenes.add(imagen);
	}

	public void setLabel(JLabel nodo) {
		this.nodo = nodo;
	}

	public JLabel getLabel() {
		return nodo;
	}
}