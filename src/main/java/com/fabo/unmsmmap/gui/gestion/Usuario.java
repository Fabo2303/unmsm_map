package com.fabo.unmsmmap.gui.gestion;

public class Usuario {
	// Atributos
	private String user;
	private String password;

	// Constructor
	public Usuario(String user, String password) {
		this.user = user;
		this.password = password;
	}

	// Métodos set y get
	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
}
