package leetcode;

import java.util.ArrayList;
import java.util.List;

class DetectCyclesInGraph {

    public static void main(String[] args) {
        DetectCyclesInGraph obj = new DetectCyclesInGraph();
        System.out.println("Detecting cycles in Undirected Graph.\n");
        System.out.println((obj.detectedACycleInUndirectedGraphVer2(5, new int [][] {{1}, {0,2,4}, {1,3}, {2,4}, {1,3}})) ? "Cycle Found" : "Cycle not found");
        System.out.println((obj.detectedACycleInUndirectedGraphVer2(3, new int [][] {{1,2}, {0,2}, {0,1}})) ? "Cycle Found" : "Cycle not found");
        System.out.println((obj.detectedACycleInUndirectedGraphVer2(3, new int [][] {{1}, {0,2}, {1}})) ? "Cycle Found" : "Cycle not found");
//        ========================================================================================================================
        System.out.println("\nDetecting cycles in Directed Graph.\n");
        System.out.println((obj.detectedACycleInDirectedGraph(3, new int [][] {{1,0}, {1,2}})) ? "Cycle Found" : "Cycle not found"); //No cycle present
        System.out.println((obj.detectedACycleInDirectedGraph(5, new int [][] {{1,0}, {1,2}, {3,2}, {4,3}, {2,4}})) ? "Cycle Found" : "Cycle not found");
        System.out.println((obj.detectedACycleInDirectedGraph(2, new int [][] {{1,0}, {0,1}})) ? "Cycle Found" : "Cycle not found"); //cycle is present
        System.out.println((obj.detectedACycleInDirectedGraph(11, new int [][] {{0,7}, {4,0}, {5,4}, {6,5}, {8,6}, {9,8}, {3,9}, {2,3}, {1,2}, {10,1}, {6,4}})) ? "Cycle Found" : "Cycle not found"); //cycle is present
        System.out.println((obj.detectedACycleInDirectedGraph(3, new int [][] {{1,0}, {2,1}, {2,0}})) ? "Cycle Found" : "Cycle not found"); //cycle is present
    }

    private boolean detectedACycleInDirectedGraph(int V, int[][] graph) {
        List<Integer>[] adj = new ArrayList[V];
        for (int [] row: graph) {
            if (null == adj[row[1]]) {
                adj[row[1]] = new ArrayList<>();
            }
            adj[row[1]].add(row[0]);
        }
        boolean [] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i] && adj[i] != null && dfsDetectDAG(visited, new boolean[V], i, adj)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsDetectDAG(boolean[] visitedBefore, boolean[] currVisited, int curr, List<Integer>[] adj) {
        if (currVisited[curr]) return true;
        visitedBefore[curr] = true;
        currVisited[curr] = true;
        if (adj[curr] != null) {
            for (int n: adj[curr]) {
                //check if this node is previously visited in alreadyVisited array
                if (!visitedBefore[n] ) {
                    if (dfsDetectDAG(visitedBefore, currVisited, n, adj)) return true;
                } else if (currVisited[n]) {
                    return true;
                }
            }
        }
        currVisited[curr] = false;
        return false;
    }

    public boolean detectedACycleInUndirectedGraphVer2(int V, int[][] adj) {
        boolean [] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i] && dfsDetect(visited, new int[V], i, adj)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfsDetect(boolean[] visitedBefore, int [] parent, int curr, int [][] dag) {
        if (visitedBefore[curr]) return true;
        visitedBefore[curr] = true;
        for (int n: dag[curr]) {
            //check my parent is current node
            if (parent[curr] != n) {
                parent[n] = curr;
                if (dfsDetect(visitedBefore, parent, n, dag)) return true;
            }
        }
        return false;
    }

}
