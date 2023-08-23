package DSA.graph;

import java.util.*;

public class GraphDemo {
    public static void main(String[] args) {
        Graph graph = new Graph();
        for (int i = 1; i <= 7; i++) {
            graph.addVertex(i);
        }
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(2, 4);
        graph.addEdge(3, 7);
        graph.addEdge(6, 6);
//        bfs(graph, 1);
        //LC 1971
        //System.out.println(new PathExistsInGraphLC1971().validPath(3, new int[][] {{0,1},{1,2},{2,0}}, 0, 2));
        dfsIncomplete(graph, 1);
    }

    private static void dfsIncomplete(Graph graph, int sourceNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(sourceNode);
        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            System.out.println(currNode+" ");
            List<Integer> neighbours = graph.getAdjacencyList().get(currNode);
            for (int neigh: neighbours) {
                stack.push(neigh);
            }
        }
    }

    private static void bfs(Graph graph, int sourceNode) {
        Map<Integer, List<Integer>> adjList = graph.getAdjacencyList();
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceNode);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            System.out.println(currNode + " ");
            visitedNodes.add(currNode);
            List<Integer> currNodes = adjList.get(currNode);
            //add all nodes which has the connections from the current node.
            for (int node : currNodes) {
                if (!visitedNodes.contains(node)) {
                    queue.add(node);
                }
            }
        }
    }

}