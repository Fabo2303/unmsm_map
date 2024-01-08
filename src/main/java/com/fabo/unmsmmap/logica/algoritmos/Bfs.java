package com.fabo.unmsmmap.logica.algoritmos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.fabo.unmsmmap.logica.grafo.Edge;
import com.fabo.unmsmmap.logica.grafo.Graph;
import com.fabo.unmsmmap.logica.grafo.Vertex;

/*
 * Clase que permite realizar la búsqueda en anchura
 */
public class Bfs<T> {
	// Ordenar los vértices por BFS y devolver el arreglo que los ha capturado
	public ArrayList<Vertex<T>> bfs(Vertex<T> nodo, Graph<T> grafo) {
		boolean visited[] = new boolean[grafo.getGraph().size()];
		ArrayList<Vertex<T>> salida = new ArrayList<Vertex<T>>();
		LinkedList<Vertex<T>> queue = new LinkedList<>();

		visited[nodo.getCod()] = true;
		queue.add(nodo);

		while (!queue.isEmpty()) {
			nodo = queue.poll();
			salida.add(nodo);
			Iterator<Edge<T>> i = nodo.getEdges().listIterator();
			
			while (i.hasNext()) {
				Edge<T> n = i.next();
				int j = n.getFinal().getCod();
				
				if (!visited[j]) {
					visited[j] = true;
					queue.add((n.getFinal()));
				}
			}
		}
		
		return salida;
	}
}
