package interviewAsked;

/**
 * Finding the minimum size array whose sum is target number.
 * Example: array: {2, 7, 6, 5, 2}
 * Target: 11
 * Ans: 2
 * Explanation: sub arrays can be {2, 7, 2} and {5, 6}
 * The min size is 2
 */
public class MinSubArrayForSum_RelianceJio {

    private static int MIN_SIZE = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int [] arr = new int[] {2,7,2,5,6};
        rec(arr, 0, 0, 11, 1);
        System.out.println(MIN_SIZE);
    }

    private static void rec(int [] arr, int index, int sum, int target, int currLen) {
        if (index == arr.length - 1) {
            if (sum + arr[index] == target) {
                MIN_SIZE = Math.min(currLen, MIN_SIZE);
            }
            return;
        }
        if (sum + arr[index] == target) {
            MIN_SIZE = Math.min(currLen, MIN_SIZE);
            return;
        }
        if (arr[index] <= target - sum) {
            rec(arr, index + 1, sum + arr[index], target, currLen + 1);
        }
        rec(arr, index + 1, sum, target, currLen);
    }
}
