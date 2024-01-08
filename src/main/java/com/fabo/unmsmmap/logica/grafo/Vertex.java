package com.fabo.unmsmmap.logica.grafo;

import java.io.Serializable;
import java.util.*;

public class Vertex<T> implements Serializable {
	// Atributos
	private int cod;
	private T dato;
	private ArrayList<Edge<T>> edges;

	// Constructores
	public Vertex(T dato, int cod) {
		this.cod = cod;
		this.dato = dato;
		this.edges = new ArrayList<>();
	}

	public Vertex() {
		this.cod = 9999;
		this.dato = null;
		this.edges = new ArrayList<>();
	}

	// Métodos set y get
	public T getDato() {
		return dato;
	}

	public int getCod() {
		return cod;
	}

	public boolean addEdge(Edge<T> edge) {
		if (edge == null)
			return false;
		edges.add(edge);
		return true;
	}

	public ArrayList<Edge<T>> getEdges() {
		if (edges.isEmpty())
			throw new RuntimeException("No hay caminos");
		return edges;
	}
}
