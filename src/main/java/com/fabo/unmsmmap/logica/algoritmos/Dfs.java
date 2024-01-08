package com.fabo.unmsmmap.logica.algoritmos;

import java.util.ArrayList;
import java.util.Iterator;

import com.fabo.unmsmmap.logica.grafo.Edge;
import com.fabo.unmsmmap.logica.grafo.Graph;
import com.fabo.unmsmmap.logica.grafo.Vertex;

/*
 * Clase que permite realizar la búsqueda a profundidad
 */
public class Dfs<T> {
	// Atributos
	boolean empezar = false;
	boolean visited[];
	int nodosVisitados = 0;
	private ArrayList<Vertex<T>> salida;

	// Ordenar los vértices por DFS
	public void dfs(Vertex<T> nodo, Graph<T> grafo) {
		if (!empezar) {
			visited = new boolean[grafo.getGraph().size()];
			salida = new ArrayList<>();
			empezar = true;
		}

		visited[nodo.getCod()] = true;
		nodosVisitados++;
		salida.add(nodo);
		Iterator<Edge<T>> i = nodo.getEdges().listIterator();

		while (i.hasNext()) {
			Edge<T> adj = i.next();
			if (!visited[adj.getFinal().getCod()])
				dfs(adj.getFinal(), grafo);
		}
	}

	// Devolver el arreglo que ha capturado los vértices ordenados
	public ArrayList<Vertex<T>> getSalida() {
		empezar = false;
		return salida;
	}
}
