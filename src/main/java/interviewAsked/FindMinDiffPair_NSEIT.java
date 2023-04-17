package interviewAsked;

import java.util.Map;
import java.util.TreeMap;

public class FindMinDiffPair_NSEIT {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 19, 18, 25};
        int n = arr.length;
        System.out.println(findMinDiff(arr));
    }
    private static int findMinDiff(int[] arr) {
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i=0; i<n; i++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(arr[i]);
            if (null != entry) {
                minDiff = Math.min(minDiff, entry.getKey() - arr[i]);
            }
            Map.Entry<Integer, Integer> lowerEntry = map.lowerEntry(arr[i]);
            if (null != lowerEntry) {
                minDiff = Math.min(minDiff, arr[i] - lowerEntry.getKey());
            }
            map.put(arr[i], i);
        }
        return minDiff;
    }
}
