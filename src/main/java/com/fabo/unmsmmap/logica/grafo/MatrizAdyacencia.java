package com.fabo.unmsmmap.logica.grafo;

import java.util.ArrayList;

import com.fabo.unmsmmap.logica.entidades.Establecimiento;

public class MatrizAdyacencia<T> {
	public int[][] matriz(ArrayList<Vertex<Establecimiento>> AEM) {
		int[][] matrix = new int[AEM.size()][AEM.size()];

		for (Vertex<Establecimiento> a : AEM) {
			ArrayList<Edge<Establecimiento>> au = a.getEdges();
			for (Edge<Establecimiento> b : au) {
				matrix[a.getCod()][b.getFinal().getCod()] = 1;
			}
		}

		return matrix;
	}
}
