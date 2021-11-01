package DSA.arrays.gen;

class MaxSubArrays {

    public static void main(String[] args) {
//        int [] nums = {1,-1,-2};
//        int [] nums = {5,4,-1,7,8};
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int [] nums = {10,0,1,-20,2,-1,10};
//        System.out.println(maxSubArray(nums));
//        System.out.println(maxSubArrayKadensApproach(nums));
        System.out.println(maxSubArrayKadensApproachShortened(nums));
    }

    public static int maxSubArrayKadensApproachShortened(int[] nums) {
        int currMax = nums[0];
        int maxSum = nums[0];
        for (int i=1; i<nums.length;i++){
            currMax = Math.max(nums[i], nums[i]+currMax);
            maxSum = Math.max(currMax, maxSum);
        }
        return maxSum;
    }

    public static int maxSubArrayKadensApproach(int[] nums) {
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