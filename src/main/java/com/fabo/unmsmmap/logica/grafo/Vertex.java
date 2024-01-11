package com.fabo.unmsmmap.logica.grafo;

import java.io.Serializable;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vertex<T> implements Serializable {
	private T dato;
	private ArrayList<Edge<T>> edges;

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
