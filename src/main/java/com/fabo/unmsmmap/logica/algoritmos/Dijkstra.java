package com.fabo.unmsmmap.logica.algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.fabo.unmsmmap.logica.grafo.Edge;
import com.fabo.unmsmmap.logica.grafo.Graph;
import com.fabo.unmsmmap.logica.grafo.Vertex;

/*
 * Clase que determina el camino mínimo entre dos vértices
 */
public class Dijkstra<T> {
	// Atributos
	private final float INF = Float.MAX_VALUE;
	private int[] previos;

	// Devolver la distancia más corta entre el vértices de inicio y destino
	public float caminoCorto(Graph<T> grafo, Vertex<T> inicio, Vertex<T> destino) {
		int numVertex = grafo.getGraph().size();
		float[] distancias = new float[numVertex];
		boolean[] visitado = new boolean[numVertex];
		previos = new int[numVertex];

		for (int i = 0; i < numVertex; i++) {
			distancias[i] = INF;
			visitado[i] = false;
			previos[i] = -1;
		}

		distancias[inicio.getCod()] = 0;

		for (int i = 0; i < numVertex - 1; i++) {
			int minVertex = encontrarMenorVertice(distancias, visitado);
			visitado[minVertex] = true;

			List<Edge<T>> edges = grafo.getGraph().get(minVertex).getEdges();
			
			for (Edge<T> edge : edges) {
				int destinationVertex = edge.getFinal().getCod();
				float weight = edge.getDistance();
				
				if (!visitado[destinationVertex] && distancias[minVertex] != INF) {
					float newDistance = distancias[minVertex] + weight;
					
					if (newDistance < distancias[destinationVertex]) {
						distancias[destinationVertex] = newDistance;
						previos[destinationVertex] = minVertex;
					}
				}
			}
		}

		return distancias[destino.getCod()];
	}

	// Devolver los vértices que componen el camino mínimo
	public ArrayList<Vertex<T>> obtenerCamino(Graph<T> grafo, Vertex<T> inicio, Vertex<T> destino) {
		ArrayList<Vertex<T>> camino = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int currentVertex = destino.getCod();

		while (currentVertex != -1) {
			stack.push(currentVertex);
			currentVertex = previos[currentVertex];
		}

		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			camino.add(grafo.getGraph().get(vertex));
		}

		return camino;
	}

	// Encontrar el número identicador del menor vértice
	public static int encontrarMenorVertice(float[] distancias, boolean[] visitado) {
		int minVertex = -1;
		
		for (int i = 0; i < distancias.length; i++) {
			if (!visitado[i] && (minVertex == -1 || distancias[i] < distancias[minVertex])) {
				minVertex = i;
			}
		}
		
		return minVertex;
	}
}