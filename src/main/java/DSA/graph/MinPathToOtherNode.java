package DSA.graph;

import java.util.*;
import java.util.stream.Collectors;

class Result {

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (List<Integer> edge : edges) {
            int e1 = edge.get(0);
            int e2 = edge.get(1);
            adjList.computeIfAbsent(e1, key -> new ArrayList<>()).add(e2);
            adjList.computeIfAbsent(e2, key -> new ArrayList<>()).add(e1);
        }

        int [] arr = new int[n];
        Arrays.fill(arr, -1);
        arr[s-1] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);

        while(!q.isEmpty()) {
            int curr = q.poll();
            for (int neighbor: adjList.getOrDefault(curr, Collections.emptyList())) {
                if (arr[neighbor-1] == -1) {
                    arr[neighbor-1] = arr[curr-1] + 6;
                    q.offer(neighbor);
                }
            }
        }

        return Arrays.stream(arr).filter(i -> i > 0).boxed().collect(Collectors.toList());
    }
}

public class MinPathToOtherNode {

    public static void main(String[] args) {

//        // Hardcoded input
//        int n = 5;
//        int m = 3;
//        List<List<Integer>> edges = new ArrayList<>();
//        edges.add(Arrays.asList(1, 2));
//        edges.add(Arrays.asList(1, 3));
//        edges.add(Arrays.asList(3, 4));
//        int s = 1;

        // Hardcoded input
//        int n = 3;
//        int m = 3;
//        List<List<Integer>> edges = new ArrayList<>();
//        edges.add(Arrays.asList(1, 2));
//        edges.add(Arrays.asList(1, 3));
//        edges.add(Arrays.asList(2, 3));
//        int s = 1;

        int n = 4;
        int m = 4;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(1, 3));
//        edges.add(Arrays.asList(1, 4));
        edges.add(Arrays.asList(3, 4));
        int s = 1;

        List<Integer> result = Result.bfs(n, m, edges, s);

        System.out.println(result);
    }
}