package DSA.dynamic_programming;

import java.util.Arrays;
public class JumpGameII {
    private static int dp[];
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
    private static int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return findMinJumpsBF(nums, 0);
    }
    private static int findMinJumpsBF(int [] nums, int index) {
        if (index + nums[index] >= nums.length - 1 || nums[index] == 0)
            return 1;
        int mJ = Integer.MAX_VALUE;
        for (int i=1; i<=nums[index]; i++) {
            mJ = Math.min(mJ, findMinJumpsBF(nums, index + i));
        }
        return mJ + 1;
    }
}
