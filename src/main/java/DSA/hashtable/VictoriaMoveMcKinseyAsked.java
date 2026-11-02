package DSA.hashtable;

import java.util.*;
import java.util.stream.Collectors;

public class VictoriaMoveMcKinseyAsked {

    public static void main(String[] args) {
        int [][] points = new int[][] {
                {5,7}, {10,2}, {2,4}, {8,2}, {1,7}, {5,2}, {3,9}, {10,7}, {8,7}, {6,3}, {1,2}, {2,9}, {6,5},
                {5,3}, {4,3}, {2,2}, {1,3}, {2,3}, {4,2}, {3,2}, {3,3}, {6,2},
        };
        System.out.println("Maximum Victoria moves: " + findMaxVictoriaMoves(points));
    }

    private static int findMaxVictoriaMoves(int [][] points) {
        Map<Integer, Set<Integer>> xValuesByY = Arrays.stream(points)
                .collect(Collectors.groupingBy(p->p[1], Collectors.mapping(p->p[0], Collectors.toSet())));
        int maxMoves = 0;
        for (Map.Entry<Integer, Set<Integer>> xEntryOuter: xValuesByY.entrySet()) {
            for (Map.Entry<Integer, Set<Integer>> xEntryInner: xValuesByY.entrySet()) {
                int maxLen = 0;
                if (xEntryInner.getKey().compareTo(xEntryOuter.getKey()) <   0) {
                    for (int num: xEntryOuter.getValue()) {
                        if (xEntryInner.getValue().contains(num)) maxLen++;
                    }
                    maxMoves = Math.max(maxMoves, maxLen);
                }
            }
        }
        return maxMoves;
    }

}
