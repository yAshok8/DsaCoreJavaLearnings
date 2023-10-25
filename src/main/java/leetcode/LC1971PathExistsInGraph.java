package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC1971PathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList[] graph = new ArrayList[n];
        for (int i=0;i<n;i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : edges) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            //why to visit the adjacent nodes of the current node if they are already covered
            if(visited[currNode])
                continue;
            if (currNode == destination)
                return true;
            visited[currNode] = true;
            List<Integer> currNodes = graph[currNode];
            //add all nodes which has the connections from the current node.
            for (int node : currNodes) {
                queue.add(node);
            }
        }
        return false;
    }

}
