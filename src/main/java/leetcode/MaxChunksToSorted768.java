package leetcode;

public class MaxChunksToSorted768 {
    public static void main(String[] args) {
        MaxChunksToSorted768 obj = new MaxChunksToSorted768();
        System.out.println(obj.maxChunksToSorted(new int[]{2,4,1,6,5,9,7}));
    }

    public int maxChunksToSorted(int [] arr) {
        int [] rightMin = new int[arr.length];
        rightMin[rightMin.length - 1] = arr[arr.length - 1];
        for (int i=arr.length - 2; i>=0; i--) {
            rightMin[i] = Math.min(arr[i], rightMin[i+1]);
        }
        int ans = 1;
        int max = arr[0];
        for (int i=0; i<rightMin.length - 1; i++) {
            max = Math.max(max, arr[i]);
            if (max <= rightMin[i+1]) {
                ans++;
            }
        }
        return ans;
    }
}
