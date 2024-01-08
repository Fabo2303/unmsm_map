package com.fabo.unmsmmap.logica.grafo;

import java.io.Serializable;
import java.util.LinkedList;

public class Edge<T> implements Serializable {
	// Atributos
	private float distance;
	private Vertex<T> destino;
	private LinkedList<Integer> camino;

	// Constructores
	public Edge() {
		this.distance = 0;
		this.destino = null;
		this.camino = new LinkedList<>();
	}

	public Edge(Vertex<T> destino, float distance) {
		this.distance = distance;
		this.destino = destino;
		this.camino = new LinkedList<>();
	}

	public Edge(Vertex<T> destino, float distance, LinkedList<Integer> camino) {
		this.distance = distance;
		this.destino = destino;
		this.camino = camino;
	}

	// Métodos set y get
	public float getDistance() {
		return distance;
	}

	public Vertex<T> getFinal() {
		return destino;
	}

	public void setCamino(LinkedList<Integer> camino) {
		this.camino = camino;
	}

	public LinkedList<Integer> getCamino() {
		return camino;
	}
}