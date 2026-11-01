

# File BellmanFord.java

[**File List**](files.md) **>** [**es**](dir_f9b1e2a59d62d001356ff527358589e3.md) **>** [**ull**](dir_5e4a5b0330a43e454ff3ad9bcb612958.md) **>** [**esit**](dir_ff138097d92aca141cd969d7c10ce4fe.md) **>** [**utilities**](dir_5612c464522cebfe44601dfa3f1684ce.md) **>** [**BellmanFord.java**](_bellman_ford_8java.md)

[Go to the documentation of this file](_bellman_ford_8java.md)


```Java
package main.java.es.ull.esit.utilities;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    private static final int INFINITY = 999999;

    private final int[][] distanceMatrix;

    private List<Integer> edges1 = null;

    private List<Integer> edges2 = null;

    private final int nodes;

    private final List<Integer> path;

    private int[] distances = null;

    private int value;

    public BellmanFord(int[][] distanceMatrix, int nodes, List<Integer> path) {
        this.distanceMatrix = distanceMatrix;
        this.nodes = nodes;
        this.path = path;
        this.calculateEdges();
        this.value = BellmanFord.INFINITY;
    }

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

    public int[] getDistances() {
        return this.distances;
    }

    public int getValue() {
        return this.value;
    }

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
```


