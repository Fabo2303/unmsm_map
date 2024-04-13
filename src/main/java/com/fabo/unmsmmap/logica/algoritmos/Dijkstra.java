package com.fabo.unmsmmap.logica.algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import com.fabo.unmsmmap.logica.entidades.Establecimiento;
import com.fabo.unmsmmap.logica.grafo.Edge;
import com.fabo.unmsmmap.utilidades.ManejadorArchivos;
import com.fabo.unmsmmap.utilidades.RutasArchivos;

public class Dijkstra {

    private static final ArrayList<Edge> edges = ManejadorArchivos.getObjectFromJson(RutasArchivos.EDGES_FILE,
            Edge.class);
    private final static float INF = Float.MAX_VALUE;
    private static int[] previos;

    // Función para encontrar el índice de un establecimiento en la lista de
    // establecimientos
    private static int findIndex(ArrayList<Establecimiento> establecimientos, String nombre) {
        for (int i = 0; i < establecimientos.size(); i++) {
            if (establecimientos.get(i).getAlias().equals(nombre)) {
                return i;
            }
        }
        return -1; // No encontrado
    }

    // Función para encontrar el establecimiento más cercano a un nodo dado
    private static Establecimiento findClosest(ArrayList<Establecimiento> establecimientos, float[] dist, boolean[] visited) {
        float minDist = INF;
        Establecimiento closest = null;
        for (Establecimiento establecimiento : establecimientos) {
            int index = findIndex(establecimientos, establecimiento.getAlias());
            if (!visited[index] && dist[index] < minDist) {
                minDist = dist[index];
                closest = establecimiento;
            }
        }
        return closest;
    }

    public static ArrayList<String> dijkstra(ArrayList<Establecimiento> establecimientos, String inicio, String fin) {
        int n = establecimientos.size();
        int startIndex = findIndex(establecimientos, inicio);
        int endIndex = findIndex(establecimientos, fin);

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Establecimiento de inicio o final no encontrado.");
            return null;
        }

        previos = new int[n];
        Arrays.fill(previos, -1);
        float[] dist = new float[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, INF);
        dist[startIndex] = 0;

        for (int count = 0; count < n - 1; count++) {
            Establecimiento u = findClosest(establecimientos, dist, visited);
            if (u == null)
                break;

            int uIndex = findIndex(establecimientos, u.getAlias());
            visited[uIndex] = true;

            for (Edge edge : edges) {
                if (edge.getOrigen().equals(u.getAlias())) {
                    int vIndex = findIndex(establecimientos, edge.getDestino());
                    float alt = dist[uIndex] + edge.getDistance();
                    if (alt < dist[vIndex]) {
                        dist[vIndex] = alt;
                        previos[vIndex] = uIndex;
                    }
                }
            }
        }

        // Reconstruir el camino más corto
        ArrayList<String> shortestPath = new ArrayList<>();
        int current = endIndex;
        while (previos[current] != -1) {
            shortestPath.add(establecimientos.get(current).getAlias());
            current = previos[current];
        }
        shortestPath.add(establecimientos.get(startIndex).getAlias());
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}