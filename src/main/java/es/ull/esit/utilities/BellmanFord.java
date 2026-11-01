package main.java.es.ull.esit.utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * @class BellmanFord
 * @brief Implementación del algoritmo de Bellman-Ford para encontrar los caminos más cortos.
 *
 * Este algoritmo evalúa las distancias más cortas desde un único nodo origen
 * hacia todos los demás nodos en un grafo dirigido ponderado.
 */
public class BellmanFord {

    /**
     * @brief Valor constante utilizado para representar el infinito en las distancias.
     */
    private static final int INFINITY = 999999;

    /**
     * @brief Matriz que representa los pesos o distancias entre los nodos del grafo.
     */
    private final int[][] distanceMatrix;

    /**
     * @brief Lista de nodos de origen de las aristas válidas del grafo.
     */
    private List<Integer> edges1 = null;

    /**
     * @brief Lista de nodos de destino de las aristas válidas del grafo.
     */
    private List<Integer> edges2 = null;

    /**
     * @brief Número total de nodos en el grafo.
     */
    private final int nodes;

    /**
     * @brief Lista que almacena la secuencia de nodos que forman el camino más corto.
     */
    private final List<Integer> path;

    /**
     * @brief Array que almacena las distancias mínimas calculadas hacia cada nodo.
     */
    private int[] distances = null;

    /**
     * @brief Valor de coste asociado al nodo final o destino.
     */
    private int value;

    /**
     * @brief Constructor de la clase BellmanFord.
     * @param distanceMatrix Matriz cuadrada con las distancias (pesos) entre nodos.
     * @param nodes Número total de nodos en el grafo.
     * @param path Lista donde se almacenará el camino resultante.
     */
    public BellmanFord(int[][] distanceMatrix, int nodes, List<Integer> path) {
        this.distanceMatrix = distanceMatrix;
        this.nodes = nodes;
        this.path = path;
        this.calculateEdges();
        this.value = BellmanFord.INFINITY;
    }

    /**
     * @brief Calcula e inicializa las aristas del grafo a partir de la matriz de distancias.
     *
     * Recorre la matriz y añade a las listas edges1 y edges2 los índices origen y destino
     * donde exista una arista válida (distancia diferente de MAX_VALUE).
     */
    private void calculateEdges() {
        this.edges1 = new ArrayList<>();
        this.edges2 = new ArrayList<>();
        for (int i = 0; i < this.nodes; i++) {
            for (int j = 0; j < this.nodes; j++) {
                if (this.distanceMatrix[i][j] != Integer.MAX_VALUE) {
                    this.edges1.add(i);
                    this.edges2.add(j);
                }
            }
        }
    }

    /**
     * @brief Obtiene el array con las distancias mínimas calculadas a cada nodo.
     * @return Array de enteros representando las distancias desde el nodo origen.
     */
    public int[] getDistances() {
        return this.distances;
    }

    /**
     * @brief Obtiene el valor del coste o distancia del nodo final.
     * @return Entero con el valor calculado de la ruta.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * @brief Ejecuta la lógica principal del algoritmo de Bellman-Ford.
     *
     * Relaja las aristas repetidamente para encontrar las distancias más cortas
     * y reconstruye el camino resultante hacia atrás basándose en los predecesores.
     */
    public void solve() {
        int numEdges = this.edges1.size();
        int[] predecessor = new int[this.nodes];
        this.distances = new int[this.nodes];
        for (int i = 0; i < this.nodes; i++) {
            this.distances[i] = BellmanFord.INFINITY;
            predecessor[i] = -1;
        }
        this.distances[0] = 0;
        for (int i = 0; i < (this.nodes - 1); i++) {
            for (int j = 0; j < numEdges; j++) {
                int u = this.edges1.get(j);
                int v = this.edges2.get(j);
                if (this.distances[v] > this.distances[u] + this.distanceMatrix[u][v]) {
                    this.distances[v] = this.distances[u] + this.distanceMatrix[u][v];
                    predecessor[v] = u;
                }
            }
        }
        this.path.add(this.nodes - 1);
        int pred = predecessor[this.nodes - 1];
        while (pred != -1) {
            this.path.add(pred);
            pred = predecessor[pred];
        }
        this.value = -this.distances[this.nodes - 1];
    }
}