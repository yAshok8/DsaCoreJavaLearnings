package DSA.graph;

import java.util.HashMap;
import java.util.Map;

public class FindCenterofStarGraphLC1791 {
    public static void main(String[] args) {
        System.out.println(findCenter(new int [][] {{1,2},{2,3},{4,2}}));
    }
    private static int findCenter(int[][] edges) {
        int ans = 0;
        int maxConnections = Integer.MIN_VALUE;
        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        for (int i=0; i<edges.length; i++) {
            int key1 = edges[i][0];
            int key2 = edges[i][1];
            inDegreeMap.put(key1, inDegreeMap.getOrDefault(key1, 0) + 1);
            inDegreeMap.put(key2, inDegreeMap.getOrDefault(key2, 0) + 1);
            if (inDegreeMap.get(key1) > maxConnections) {
                maxConnections = inDegreeMap.get(key1);
                ans = key1;
            }
            if (inDegreeMap.get(key2) > maxConnections) {
                maxConnections = inDegreeMap.get(key2);
                ans = key2;
            }
        }
        return ans;
    }

}
