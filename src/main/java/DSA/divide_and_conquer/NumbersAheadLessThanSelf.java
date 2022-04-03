package DSA.divide_and_conquer;

public class NumbersAheadLessThanSelf {

    public static void main(String[] args) {
        int [] nums = {3,1,7,4,2,0,7,9};
        int [] sortedArray = mergeSort(nums, 0, nums.length);
        for (int elem: sortedArray) {
            System.out.print(elem + " ");
        }
    }

    private static int[] mergeSort(int[] nums, int low, int high) {
        if (high <= 1)
            return nums;
        int mid = (low + high) / 2;
        int [] leftArray = new int[mid - low];
        System.arraycopy(nums, low, leftArray, 0, mid - low);
        int [] rightArray = new int[high - mid];
        System.arraycopy(nums, mid, rightArray, 0, high - mid);
        //get left array sorted
        int [] leftSortedArray = mergeSort(leftArray, 0, leftArray.length);
        //get right array sorted
        int [] rightSortedArray = mergeSort(rightArray, 0, rightArray.length);
        //merge left and right
        //return merged array
        return mergeSortedArray(leftSortedArray, rightSortedArray);
    }

    //{1,4}, {2,5}

    private static int[] mergeSortedArray(int[] leftSortedArray, int[] rightSortedArray) {
        int l = 0;
        int r = 0;
        int [] mergedArray = new int[leftSortedArray.length + rightSortedArray.length];
        int index = 0;
        while (l < leftSortedArray.length && r < rightSortedArray.length) {
            if (leftSortedArray[l] < rightSortedArray[r]) {
                mergedArray[index++] = leftSortedArray[l++];
            } else {
                mergedArray[index++] = rightSortedArray[r++];
            }
        }
        if (l < leftSortedArray.length) {
            System.arraycopy(leftSortedArray, l, mergedArray, index, leftSortedArray.length - l);
        } else {
            System.arraycopy(rightSortedArray, r, mergedArray, index, rightSortedArray.length - r);
        }
        return mergedArray;
    }


    private static int[] getArray(int low, int high, int [] nums) {
        int[] arr = new int[high - low];
        for (int i = low; i<=high; i++) {
            arr[i-low] = nums[i];
        }
        return arr;
    }


}
