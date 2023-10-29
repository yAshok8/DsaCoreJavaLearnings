package DSA.arrays.gen;

class LC56MaxSumSubArrays {

    public static void main(String[] args) {
        LC56MaxSumSubArrays obj = new LC56MaxSumSubArrays();
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(obj.maxSumSubArrayOptimized(nums));
    }

    public int maxSumSubArrayOptimized(int [] nums) {
        int curr = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i] + curr) {
                curr = nums[i];
            } else {
                curr += nums[i];
            }
            max = Math.max(max, curr);
        }
        return max;
    }


    public int maxSubArrayKadensApproachShortened(int[] nums) {
        int currMax = nums[0];
        int maxSum = nums[0];
        for (int i=1; i<nums.length;i++){
            currMax = Math.max(nums[i], nums[i]+currMax);
            maxSum = Math.max(currMax, maxSum);
        }
        return maxSum;
    }

    public int maxSubArrayKadensApproach(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int currentMax = nums[0];
        int maxSum = currentMax;
        for (int i=1; i<nums.length;i++){
            if(currentMax < 0)
                currentMax = Math.max(currentMax, nums[i]);
            else
                currentMax = Math.max(nums[i], nums[i]+currentMax);
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }


    public static int maxSubArray(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        int size = nums.length;
        int [][] dynamicPalindromeMat = new int [size][size];
        for(int i=0; i<=size-1; i++) {
            int innerI = i;
            for (int j = 0; j <= size - 1 - i; j++) {
                int right = innerI++;
                if(i==0){
                    dynamicPalindromeMat[j][right] = nums[j];
                }else{
                    if(i==1){
                        dynamicPalindromeMat[j][right] = nums[j] + nums[right];
                    }else{
                        dynamicPalindromeMat[j][right] = nums[j] + nums[right] + dynamicPalindromeMat[j+1][right-1];
                    }
                }
                maxVal = Math.max(maxVal, dynamicPalindromeMat[j][right]);
            }
        }
        return maxVal;
    }
}