package interviewAsked;

import java.util.*;

/**
 * Problem Description:
 * https://leetcode.com/discuss/interview-question/580059/software-developer-interview-question-just-come-across
 */
public class MinPathToSchool_Altimatrik {
    public static void main(String[] args) {

        int[][] nodes1 = {{1,2,9},{2,3,11},{3,4,6},{4,5,1},{5,1,4},{3,5,10}};
        int x1=2, y1=3, numOfNodes1=5;
        int[][] nodes2 = {{1,2,6},{1,4,9},{2,4,10},{2,3,6},{3,4,11}};
        int x2=2, y2=3, numOfNodes2=4;
        getMinPath(nodes1, x1, y1);
        System.out.println(res);
    }

    private static void getMinPath(int[][] nodes, int x1, int y1) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> nodesMap = new HashMap<>();
        for (int [] arr: nodes) {
            nodesMap.putIfAbsent(arr[0], new HashMap<>());
            nodesMap.putIfAbsent(arr[1], new HashMap<>());
            nodesMap.get(arr[0]).put(arr[1], arr[2]);
            nodesMap.get(arr[1]).put(arr[0], arr[2]);
        }
        dfsTraverse(nodesMap, set, x1, y1, 0, 1);
    }
    static int res = Integer.MAX_VALUE;

    private static void dfsTraverse(Map<Integer, Map<Integer, Integer>> paths, Set<Integer> vN, int x, int y, int cd, int cN) {
        if (vN.contains(y) && !vN.contains(x) || cd > res) return;
        if (cN == paths.entrySet().size() && vN.contains(x) && vN.contains(y)) {
            res = Math.min(res, cd);
            return;
        }
        vN.add(cN);
        for (Map.Entry<Integer, Integer> entryObj: paths.get(cN).entrySet()) {
            if (!vN.contains(entryObj.getKey())) {
                dfsTraverse(paths, vN, x, y, cd + entryObj.getValue(), entryObj.getKey());
            }
        }
        vN.remove(cN);
    }
}
