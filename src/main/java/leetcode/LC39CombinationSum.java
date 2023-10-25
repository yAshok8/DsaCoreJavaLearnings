package leetcode;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class LC39CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        LC39CombinationSum obj = new LC39CombinationSum();
        System.out.println(obj.combinationSum(new int[]{2,3,5,7}, 7));
        System.out.println(obj.combinationSum(new int[]{2,3,6,7}, 9));
        System.out.println(obj.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(obj.combinationSum(new int[]{2,3}, 8));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans.clear();
        Arrays.sort(candidates);
        calculateCombinedSum(candidates, 0, new ArrayList<>(), target);
        return ans;
    }

    private void calculateCombinedSum(int [] ar, int I, List<Integer> currList, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(currList));
            return;
        }
        for (int i=I; i<ar.length; i++) {
            if (ar[i] > target) break;
            if (ar[i] <= target) {
                currList.add(ar[i]);
                calculateCombinedSum(ar, i, currList, target-ar[i]);
                currList.remove(currList.size() - 1);
            }
        }
    }
}
