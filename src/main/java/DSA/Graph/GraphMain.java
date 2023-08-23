package DSA.Graph;

import leetcode.PathExistsInGraphLC1971;

import java.util.*;

public class GraphMain {
    public static void main(String[] args) {
        GraphClass graph = new GraphClass();
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
        //printing the graph
//        graph.printGraph();
        bfsTraversal(graph, 1);
        System.out.println(new PathExistsInGraphLC1971().validPath(3, new int[][] {{0,1},{1,2},{2,0}}, 0, 2));
//        System.out.println(validPathCopied(3, new int[][] {{0,1},{1,2},{2,0}}, 0, 2));
    }

    private static void bfsTraversal(GraphClass graph, int sourceNode) {
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
