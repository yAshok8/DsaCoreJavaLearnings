package leetcode;

import java.util.*;

class CombinationSumIILC40 {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        CombinationSumIILC40 obj = new CombinationSumIILC40();
        System.out.println(obj.combinationSumII(new int[]{2,3}, 8));
        System.out.println(obj.combinationSumII(new int[]{2,3,5}, 8));
        System.out.println(obj.combinationSumII(new int[]{1,2,2,3}, 5));
        System.out.println(obj.combinationSumII(new int[]{5,3,4,6,7}, 15));
        System.out.println(obj.combinationSumII(new int[]{7,2,5,2,3,6}, 9));
        System.out.println(obj.combinationSumII(new int[]{1,1,1,2,2,2,2,2}, 10));
        System.out.println(obj.combinationSumII(new int[]{10,1,2,7,6,1,5}, 8));
    }
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        ans.clear();
        Arrays.sort(candidates);
        calculateCombinedSumII(candidates, 0, new ArrayList<>(), target);
        return ans;
    }

    private void calculateCombinedSumII(int [] ar, int I, List<Integer> currList, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i=I; i<ar.length; i++) {
            if (!set.contains(ar[i])) {
                if (ar[i] > target) break;
                if (ar[i] <= target) {
                    currList.add(ar[i]);
                    calculateCombinedSumII(ar, i+1, currList, target-ar[i]);
                    currList.remove(currList.size() - 1);
                }
            }
            set.add(ar[i]);
        }
    }
}
