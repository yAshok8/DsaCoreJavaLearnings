package leetcode;

import java.util.ArrayList;
import java.util.List;

class LC2477MinimumFuelCost {

    private long ans = 0;

    public static void main(String[] args) {
//        int [][] roads = new int[][]{{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}};
        int [][] roads = new int[][]{{0,1}, {0,2}, {1,3}, {1, 4}};
//        int [][] roads = new int[][]{};
        int seats = 5;
        LC2477MinimumFuelCost obj = new LC2477MinimumFuelCost();
        obj.minimumFuelCost(roads, seats);
    }
    private void minimumFuelCost(int[][] roads, int seats) {
        List<Integer>[] graph = new List[roads.length+1];
        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int [] road: roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        boolean [] visited = new boolean[roads.length + 1];
        getCost(graph, visited, 0, seats);
        System.out.println(ans);
    }

    private long getCost(List<Integer>[] graph, boolean [] visited, int source, int seats) {
        if (visited[source])
            return 0;
        visited[source] = true;
        int personCount = 1;
        for (int neighbour : graph[source]) {
            personCount += getCost(graph, visited, neighbour, seats);
        }
        if (source != 0) {
            int sum = (personCount + seats - 1) / seats;
            ans += sum;
        }
        return personCount;
    }

}


