package DSA.sliding_window;

import java.util.Arrays;

public class PeakRequestsSimple {

    public static int peakRequests(long[] timestamps, long window) {
        if (timestamps.length == 0) return 0;
        if (timestamps.length == 1) return 1;
        int left = 0;
        long maxCount = 1;
        int index = 0;
        while (index < timestamps.length) {
            long currNum = timestamps[index];
            while (timestamps[left] <= currNum - window) left++;
            maxCount = Math.max(maxCount, index - left + 1);
            index++;
        }
        maxCount = Math.max(maxCount, index - left);
        return Math.toIntExact(maxCount);
    }

    public static void main(String[] args) {
        long[][] inputs = {
            {},
            {5},
            {0, 10},
            {7, 7, 7},
            {0, 1, 1, 4, 10, 10, 11}
        };
        long[] windows = {10, 10, 10, 1, 10};
        int[] expected = {0, 1, 1, 3, 5};
        int passed = 0;
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Test " + (i + 1));
            System.out.println("-------");
            System.out.println("Input: " + Arrays.toString(inputs[i]));
            System.out.println("Window: " + windows[i]);
            System.out.println("Expected: " + expected[i]);
            int actual = peakRequests(inputs[i], windows[i]);
            System.out.println("Actual: " + actual);
            if (actual == expected[i]) {
                passed++;
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
            }
            System.out.println();
        }
        System.out.println("Passed: " + passed + " / " + inputs.length);

//        long [] input = new long[]{0, 1, 1, 4, 10, 10, 11};
//        long window = 10;
//        int actual = peakRequests(input, window);
//        System.out.println(actual);
    }
}
