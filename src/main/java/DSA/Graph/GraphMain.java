package DS;

import java.util.*;

public class GraphMain {
    public static void main(String[] args) {
        GraphClass graph = new GraphClass();
        for (int i=1;i<=7;i++) {
            graph.addVertex(i);
        }
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(2,4);
        graph.addEdge(3,7);
        graph.addEdge(6,6);
        //printing the graph
//        graph.printGraph();
        dfsTraversal(graph, 1);
    }

    private static void dfsTraversal(GraphClass graph, int sourceNode) {
        Map<Integer, List<Integer>> adjList = graph.getAdjacencyList();
        Set<Integer> visitedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceNode);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            System.out.println(currNode+" ");
            visitedNodes.add(currNode);
            List<Integer> currNodes = adjList.get(currNode);
            //add all nodes which has the connections from the current node.
            for (int node: currNodes) {
                if (!visitedNodes.contains(node)) {
                    queue.add(node);
                }
            }
        }
    }
}
