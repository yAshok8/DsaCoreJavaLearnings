package leetcode;

class LC153FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
        LC153FindMinimuminRotatedSortedArray obj = new LC153FindMinimuminRotatedSortedArray();
        System.out.println(obj.findMin(new int[]{2,1}));
    }
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid>0 && nums[mid-1] > nums[mid])
                return nums[mid];
            if (mid<nums.length-1 && nums[mid+1] < nums[mid])
                return nums[mid+1];
            if (nums[left] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[0];
    }
}
