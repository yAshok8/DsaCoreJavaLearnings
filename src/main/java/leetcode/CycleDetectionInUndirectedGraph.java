package leetcode;

class CycleDetectionInUndirectedGraph {

    public static void main(String[] args) {
        CycleDetectionInUndirectedGraph obj = new CycleDetectionInUndirectedGraph();
        System.out.println((obj.detectedACycleinUndirectedGraph(3, new int [][] {{1,2}, {0,2}, {0,1}})) ? "Cycle Found" : "Cycle not found");
        System.out.println((obj.detectedACycleinUndirectedGraph(3, new int [][] {{1}, {0,2}, {1}})) ? "Cycle Found" : "Cycle not found");
    }

    public boolean detectedACycleinUndirectedGraph(int V, int[][] adj) {
        boolean [] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                if (dfsDetect(visited, i, -1, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsDetect(boolean[] visited, int curr, int parent, int [][] dag) {
        visited[curr] = true;
        for (int n: dag[curr]) {
            //check my parent is current node
            if (!visited[n]) {
                if (dfsDetect(visited, n, curr, dag)) return true;
            }
            else if (parent != n) {
                return true;
            }
        }
        return false;
    }

    public boolean detectedACycleinUndirectedGraphVer2(int V, int[][] adj) {
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
