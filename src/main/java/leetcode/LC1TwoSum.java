package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LC1TwoSum {

    public static void main(String[] args) {
        LC1TwoSum ob = new LC1TwoSum();
        System.out.println(Arrays.toString(ob.twoSum(new int[]{3, 2, 4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (!map.containsKey(target-nums[i])) {
                map.put(nums[i], i);
            } else {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                break;
            }
        }
        return ans;
    }
}
