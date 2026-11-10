package DSA.binary_search;

public class PlainBinarySearch {

    public static void main(String[] args) {
        int [] sortedNums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        plainBS(sortedNums, 45);
        plainBS(sortedNums, 0);
        plainBS(sortedNums, 100);
        plainBS(sortedNums, 101);
    }

    public static void plainBS(int [] sortedNums, int target) {
        int l = 0;
        int h = sortedNums.length;
        while (l<h) {
            int mid = l + (h - l) / 2;
            if (sortedNums[mid] > target)
                h = mid;
            else
                l = mid + 1;
        }
        System.out.println("Target " + target + " would be on position " + (l + 1));
    }

}
