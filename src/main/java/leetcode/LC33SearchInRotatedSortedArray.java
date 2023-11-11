package leetcode;

class LC33SearchInRotatedSortedArray {

    public static void main(String[] args) {
        LC33SearchInRotatedSortedArray obj = new LC33SearchInRotatedSortedArray();
        System.out.println(obj.search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(obj.search(new int[] {7,8,0,1,2,4,5}, 0));
        System.out.println(obj.search(new int[] {1}, 0));
        System.out.println(obj.search(new int[] {1}, 1));
        System.out.println(obj.search(new int[] {1,3}, 0));
        System.out.println(obj.search(new int[] {1,3}, 1));
        System.out.println(obj.search(new int[] {4,5,6,7,0,1,2}, 3));
        System.out.println(obj.search(new int[] {4,5,6,7,0,1,2}, 3));
        System.out.println(obj.search(new int[] {3,1}, 1));
    }
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[l]) {
                //left portion is sorted
                //check if the left portion contains the target
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //right portion is sorted
                //check if the right portion contains the target
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
