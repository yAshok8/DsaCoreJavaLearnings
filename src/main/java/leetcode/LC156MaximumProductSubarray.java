package leetcode;

class LC156MaximumProductSubarray {

    public static void main(String[] args) {
        LC156MaximumProductSubarray obj = new LC156MaximumProductSubarray();
        System.out.println(obj.maxProduct(new int[] {-4, -3}));
        System.out.println(obj.maxProduct(new int[] {2,3,-2,-1}));
        System.out.println(obj.maxProduct(new int[] {-2,3,-4}));
        System.out.println(obj.maxProduct(new int[] {0,2}));
        System.out.println(obj.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(obj.maxProduct(new int[]{-2, 3, 4, 0, -1, -64}));
    }

    public int maxProduct(int[] nums) {
        int preFix = 1;
        int suffix = 1;
        int res = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (preFix == 0) preFix = 1;
            if (suffix == 0) suffix = 1;
            preFix *= nums[i];
            suffix *= nums[nums.length-1-i];
            res = Math.max(res, Math.max(preFix, suffix));
        }
        return res;
    }

/*
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int ans = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == 0) {
                max = 1;
                min = 1;
                ans = Math.max(ans, 0);
            } else {
                if (max == 1 && min == 1) {
                    max = Math.max(1, nums[i]);
                    min = Math.min(1, nums[i]);
                } else {
                    int a = max * nums[i];
                    int b = min * nums[i];
                    max = Math.max(a, b);
                    min = Math.min(a, b);
                }
                ans = Math.max(ans, max);
            }
        }
        return ans;
    }
*/

/*        public int maxProduct(int[] nums) {
            int max = 1;
            int min = 1;
            int res = nums[0];
            for (int num: nums) {
                if (num == 0) {
                    max = min = 1;
                    continue;
                }
                int temp = max * num;
                max = Math.max(Math.max(num*max, num*min), num);
                min = Math.max(Math.max(num*min, temp), num);
                res = Math.max(res, max);
            }
            return res;
        }*/

}
