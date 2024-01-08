package com.fabo.unmsmmap.logica.entidades;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Clase que representa una facultad de la universidad
 */
public class Facultad extends Establecimiento {
	String codigo, telefonoContacto, correoContacto;

	// Constructores
	public Facultad(String nom, String desc, ImageIcon logo, ArrayList<ImageIcon> ims, JLabel nodo, String cod,
			String tel, String corElec) {
		super(nom, desc, logo, ims, nodo);
		codigo = cod;
		telefonoContacto = tel;
		correoContacto = corElec;
	}

	public Facultad(String nom, String desc, String cod, String tel, String corElec) {
		super(nom, desc);
		codigo = cod;
		telefonoContacto = tel;
		correoContacto = corElec;
	}

	public Facultad(String nom, String desc) {
		super(nom, desc);
	}
	
	public Facultad() {
		
	}

	// Métodos set y get
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTelContacto() {
		return this.telefonoContacto;
	}

	public void setTelContacto(String telCont) {
		telefonoContacto = telCont;
	}

	public String getCorElec() {
		return this.correoContacto;
	}

	public void setCorElec(String corElec) {
		correoContacto = corElec;
	}

	// Imprimir los datos guardados de una facultad
	@Override
	public String toString() {
		String fac;
		fac = "Facultad [Nombre: " + super.getNombre() + ", Descripción: " + super.getDescripcion()
		+ ", Código: " + this.getCodigo() + ", Teléfono: " + this.getTelContacto()
		+ ", Correo electrónico: " + this.getCorElec() + " ]";
		return fac;
	}
}