package leetcode;

public class MaxChunksToSorted768 {
    public static void main(String[] args) {
        MaxChunksToSorted768 obj = new MaxChunksToSorted768();
        System.out.println(obj.maxChunksToSorted(new int[]{2,1,3,4,4}));
    }

    public int maxChunksToSorted(int [] arr) {
        int [] leftMax = new int[arr.length];
        int [] rightMin = new int[arr.length];
        int max = arr[0];
        leftMax[0] = max;
        int min = arr[arr.length - 1];
        rightMin[arr.length - 1] = min;
        for (int i=1; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
            leftMax[i] = max;
        }
        for (int i=arr.length - 1; i>=0; i--) {
            min = Math.min(min, arr[i]);
            rightMin[i] = min;
        }
        int ans = 0;
        for (int i=1; i<rightMin.length; i++) {
            if (leftMax[i-1] < rightMin[i]) {
                ans++;
            }
        }
        return ans;
    }
}
