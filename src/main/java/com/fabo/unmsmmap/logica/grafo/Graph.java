package com.fabo.unmsmmap.logica.grafo;

import java.io.Serializable;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Graph<T> implements Serializable {

	private ArrayList<Vertex<T>> graph;
}
