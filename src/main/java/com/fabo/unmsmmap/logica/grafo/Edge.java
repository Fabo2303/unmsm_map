package com.fabo.unmsmmap.logica.grafo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Edge<T> implements Serializable {
	// Atributos
	private String origen, destino, camino;
	private float distance;
}