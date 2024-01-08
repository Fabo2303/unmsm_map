package com.fabo.unmsmmap.logica.grafo;

import java.io.Serializable;
import java.util.*;

public class Graph<T> implements Serializable {
	// Atributos
	private ArrayList<Vertex<T>> graph;

	// Constructores
	public Graph() {
		graph = new ArrayList<>();
	}

	public Graph(ArrayList<Vertex<T>> graph) {
		this.graph = graph;
	}

	// Métodos set y get
	public ArrayList<Vertex<T>> getGraph() {
		return graph;
	}

	public Vertex<T> getVertice(int codigo) {
		return graph.get(codigo);
	}

	public void setVertice(Vertex<T> aux) {
		graph.add(aux);
	}

	public void setGraph(ArrayList<Vertex<T>> graph) {
		this.graph = graph;
	}
}
