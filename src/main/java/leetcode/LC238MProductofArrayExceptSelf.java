package leetcode;

import java.util.Arrays;

class LC238MProductofArrayExceptSelf {

    public static void main(String[] args) {
        LC238MProductofArrayExceptSelf obj = new LC238MProductofArrayExceptSelf();
        System.out.println(Arrays.toString(obj.productExceptSelfOptimized(new int[]{-1,1,0,-3,3})));
        System.out.println(Arrays.toString(obj.productExceptSelfOptimized(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(obj.productExceptSelfBF(new int[]{0,0})));
    }

    public int[] productExceptSelfOptimized(int[] nums) {
        int left = 1;
        int right = 1;
        //calculate right
        for (int num : nums) right *= num;
        int [] ans = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            left *= (i>0) ? nums[i-1] : 1;
            //decide if to calculate right or not
            if (right == 0 && nums[i] == 0) {
                right = 1;
                for (int j=i+1; j<nums.length; j++) {
                    right *= nums[j];
                }
            } else {
                right /= (nums[i] != 0) ? nums[i] : 1;
            }
            ans[i] = left * right;
        }
        return ans;
    }

    public int[] productExceptSelfBF(int[] nums) {
        int left = 1;
        int right = 1;
        int [] ans = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) left *= nums[j];
            for (int j=i+1; j<nums.length; j++) right *= nums[j];
            ans[i] = left * right;
            left = right = 1;
        }
        return ans;
    }
}
