package DSA.arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
//        int [] elems = new int[] {19, 20, 22, 23, 45, 3, 9, 14, 18};
//        int [] elems = new int[] { 9, 14, 18, 19, 20, 22, 23, 45, 3};
        int [] elems = new int[] {9, 14};
        int [] absentElements = new int[] {3, 18, 1, 2, 4, 5};
        for (int elem: absentElements) {
            System.out.println("Element "+elem+" is"+(isElemPresent(elem, elems) ? "" : " not") + " found");
        }
    }

    /**
     * Checks if element is present in rotated array.
     * @param target the element to be searched.
     * @param nums the target array
     * @return flag of element is found or not
     */
    private static boolean isElemPresent(int target, int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int size = nums.length;
        int r = calculateRotationFactor(nums);
        while (start <= end) {
            int mid = (start + end) / 2;
            int resIndex = (mid + r) % size;
            if (nums[resIndex] == target) {
                return true;
            }
            if (target < nums[resIndex])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    /**
     * To calculate how many time the array is being rotated.
     * @param elems the rotated array
     * @return the rotation factor
     */
    private static int calculateRotationFactor(int[] elems) {
        int start = 0;
        int end = elems.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid != 0 && elems[mid] < elems[mid-1])
                return mid;
            if (mid != elems.length && elems[mid] > elems[mid+1])
                return mid + 1;
            if (elems[mid] > elems[start])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return 0;
    }


}
