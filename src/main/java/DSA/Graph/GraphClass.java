package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphClass implements Graph {

    private Map<Integer, List<Integer>> adjacencyList = null;

    public GraphClass() {
        adjacencyList = new HashMap<>();
    }
    @Override
    public void addVertex(Integer vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    @Override
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
