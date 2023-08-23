package DSA.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList = null;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Integer vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(Integer source, Integer destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void printGraph() {
        System.out.println(adjacencyList);
    }
}