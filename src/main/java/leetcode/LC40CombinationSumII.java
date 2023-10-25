package leetcode;

import java.util.*;

class LC40CombinationSumII {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        LC40CombinationSumII obj = new LC40CombinationSumII();
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
        for (int i=I; i<ar.length; i++) {
            if (i==I || ar[i] != ar[i-1]) {
                if (ar[i] > target) break;
                if (ar[i] <= target) {
                    currList.add(ar[i]);
                    calculateCombinedSumII(ar, i+1, currList, target-ar[i]);
                    currList.remove(currList.size() - 1);
                }
            }
        }
    }
}
