package leetcode;

import java.util.*;

class LC46Permutation {

    private static final List<List<Integer>> RESULT = new ArrayList<>();

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
        System.out.println(RESULT);
    }

    private static List<List<Integer>> permute(int[] nums) {
        rec(nums, new LinkedHashSet<>());
        return RESULT;
    }

    private static void rec(int[] nums, LinkedHashSet<Integer> set) {
        if (set.size() == nums.length) {
            RESULT.add(new ArrayList<>(set));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                rec(nums, set);
                set.remove(nums[i]);
            }
        }
    }
}
