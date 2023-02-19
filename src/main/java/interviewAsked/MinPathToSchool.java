package interviewAsked;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinPathToSchool {

    private static int MIN_PATH = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int [] gFrom = new int[]{1,2,3,4,5,3};
        int [] gTo = new int[]{2,3,4,5,1,5};
        int [] gWeight = new int[]{9,11,6,1,4,10};
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i=0; i<gFrom.length; i++) {
            map.putIfAbsent(gFrom[i], new HashMap<>());
            map.putIfAbsent(gTo[i], new HashMap<>());
            map.get(gFrom[i]).put(gTo[i], gWeight[i]);
            map.get(gTo[i]).put(gFrom[i], gWeight[i]);
        }
        findMinPath(map, new HashSet<Integer>(), 2, 3, 0, 1);
        System.out.println(MIN_PATH);
    }

    private static void findMinPath(Map<Integer, Map<Integer, Integer>> map, HashSet<Integer> vN, int x, int y, int cd, int cN) {
        //check if 2nd node is present and first is not present
        if (vN.contains(y) && !vN.contains(x) || cd > MIN_PATH) {
            return;
        }
        if (cN == map.entrySet().size() && vN.contains(x) && vN.contains(y)) {
            MIN_PATH = Math.min(cd, MIN_PATH);
            return;
        }
        vN.add(cN);
        for (Map.Entry<Integer, Integer> entry: map.get(cN).entrySet()) {
            if (!vN.contains(entry.getKey())) {
                findMinPath(map, vN, x, y, entry.getValue() +  cd, entry.getKey());
            }
        }
        vN.remove(cN);
    }
}
