package leetcode;

class LC643MaximumAverageSubarrayI {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
//        System.out.println(findMaxAverage(new int[]{1,2,3,4,5,6,7,8}, 4));
//        System.out.println(findMaxAverage(new int[]{0,4,0,3,2}, 1));
//        System.out.println(findMaxAverage(new int[]{-1}, 1));
//        System.out.println(Math.max(-1,  Integer.MIN_VALUE  * -1));
    }
    private static double findMaxAverage(int[] nums, int k) {
        double ans = Integer.MIN_VALUE * -1;
        double temp = 0.0;
        int l=0, r=0;
        while(r < nums.length) {
            if (r<k) {
                temp += nums[r];
            } else {
                double avg = temp / k;
                ans = Math.max(avg, ans);
                temp += nums[r];
                temp -= nums[l];
                l++;
            }
            r++;
        }
        ans = Math.max(ans, temp / k);
        return ans;
    }
}
