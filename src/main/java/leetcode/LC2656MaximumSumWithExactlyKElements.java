package leetcode;

class LC2656MaximumSumWithExactlyKElements {

    public static void main(String[] args) {
        LC2656MaximumSumWithExactlyKElements obj = new LC2656MaximumSumWithExactlyKElements();
        System.out.println(obj.maximizeSum(new int []{1,2,3,4,5}, 3));
    }

    public int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int num: nums) {
            max = Math.max(num, max);
        }
        int ans = 0;
        for (int i=0; i<k; i++) {
            if (i != 0) max += 1;
            ans += max;
        }
        return ans;
    }
}
