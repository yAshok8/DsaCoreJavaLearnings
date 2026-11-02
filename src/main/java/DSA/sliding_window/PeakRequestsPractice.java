package DSA.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Peak Request Volume: Java practice harness.
 *
 * Edit peakRequests(...) only. No solution logic is included.
 *
 * Contract:
 * - timestamps are sorted in nondecreasing order; duplicates are allowed.
 * - 0 <= timestamps[i] <= 1_000_000_000_000.
 * - 1 <= window <= 1_000_000_000.
 * - Count requests in (t - window, t]: exclude the left boundary,
 *   include the right boundary, and count duplicate requests separately.
 * - Return the largest such count; return 0 for empty input.
 * - Up to 200,000 timestamps.
 *
 * Run from the folder containing this file:
 *   javac PeakRequestsPractice.java
 *   java PeakRequestsPractice
 *
 * The 44 small inputs and all 50 expected answers are hard-coded.
 * Six large inputs are built from fixed constants by fixture helpers.
 * Those helpers generate input data only; they do not compute answers.
 */
public class PeakRequestsPractice {

    // Set false to run only the 44 small tests while debugging.
    private static final boolean RUN_LARGE_TESTS = true;

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
        List<TestCase> tests = buildTests();
        int passed = 0;
        int failed = 0;
        long suiteStart = System.nanoTime();

        System.out.println("PEAK REQUEST VOLUME - PRACTICE TESTS");
        System.out.println("Window convention: (t - window, t]");
        System.out.println("Total test cases: " + tests.size());
        System.out.println();

        for (int index = 0; index < tests.size(); index++) {
            TestCase test = tests.get(index);
            Integer actual = null;
            Exception error = null;
            long testStart = System.nanoTime();

            try {
                // Protect the displayed fixture if your solution mutates input.
                actual = peakRequests(test.timestamps.clone(), test.window);
            } catch (Exception ex) {
                error = ex;
            }

            double elapsedMs = (System.nanoTime() - testStart) / 1_000_000.0;
            boolean success = error == null && actual.intValue() == test.expected;

            if (success) {
                passed++;
            } else {
                failed++;
            }

            System.out.printf(
                Locale.ROOT,
                "Test case %02d: %s - %s%n",
                index + 1, success ? "PASSED" : "FAILED", test.name);
            System.out.println("  Input timestamps: " + describe(test.timestamps));
            System.out.println("  Input window:     " + test.window);
            System.out.println("  Expected output:  " + test.expected);

            if (error == null) {
                System.out.println("  Actual output:    " + actual);
            } else {
                System.out.println(
                    "  Actual output: ERROR - "
                    + error.getClass().getSimpleName()
                    + (error.getMessage() == null ? "" : ": " + error.getMessage()));
            }

            System.out.printf(Locale.ROOT, "  Time:             %.3f ms%n%n", elapsedMs);
        }

        double totalMs = (System.nanoTime() - suiteStart) / 1_000_000.0;
        System.out.println("========================================");
        System.out.println("Passed: " + passed + " / " + tests.size());
        System.out.println("Failed: " + failed + " / " + tests.size());
        System.out.printf(Locale.ROOT, "Total time: %.3f ms%n", totalMs);

        if (passed == tests.size()) {
            System.out.println("ALL TEST CASES PASSED");
        } else {
            System.out.println("Review the failed cases above.");
        }
    }

    private static List<TestCase> buildTests() {
        List<TestCase> tests = new ArrayList<>();

        add(tests, "Empty input",
            new long[] {}, 10L, 0);

        add(tests, "Single request at zero",
            new long[] {0L}, 1L, 1);

        add(tests, "Single ordinary timestamp",
            new long[] {42L}, 10L, 1);

        add(tests, "Single maximum timestamp",
            new long[] {1000000000000L}, 1000000000L, 1);

        add(tests, "Two requests inside one window",
            new long[] {2L, 5L}, 10L, 2);

        add(tests, "Two requests exactly one window apart",
            new long[] {0L, 10L}, 10L, 1);

        add(tests, "Two requests farther apart than the window",
            new long[] {0L, 11L}, 10L, 1);

        add(tests, "Two requests just inside the boundary",
            new long[] {0L, 9L}, 10L, 2);

        add(tests, "Duplicate timestamps with minimum window",
            new long[] {7L, 7L, 7L}, 1L, 3);

        add(tests, "Consecutive timestamps with minimum window",
            new long[] {0L, 1L, 2L, 3L}, 1L, 1);

        add(tests, "Mixed duplicates with minimum window",
            new long[] {0L, 0L, 1L, 1L, 1L, 2L}, 1L, 3);

        add(tests, "All timestamps identical",
            new long[] {5L, 5L, 5L, 5L, 5L}, 10L, 5);

        add(tests, "Window includes the entire input",
            new long[] {0L, 2L, 4L, 6L, 8L}, 100L, 5);

        add(tests, "Original mock example",
            new long[] {0L, 1L, 1L, 4L, 10L, 10L, 11L}, 10L, 5);

        add(tests, "Steady arrivals across sliding boundaries",
            new long[] {1L, 2L, 3L, 4L, 5L, 6L}, 3L, 3);

        add(tests, "Largest burst at the beginning",
            new long[] {0L, 0L, 1L, 2L, 100L, 200L}, 3L, 4);

        add(tests, "Largest burst at the end",
            new long[] {0L, 100L, 200L, 201L, 202L, 202L}, 3L, 4);

        add(tests, "Largest burst in the middle",
            new long[] {0L, 100L, 101L, 101L, 102L, 500L}, 3L, 4);

        add(tests, "Separate bursts with equal peaks",
            new long[] {0L, 1L, 2L, 20L, 21L, 22L}, 3L, 3);

        add(tests, "Earlier maximum must be remembered",
            new long[] {0L, 1L, 1L, 1L, 2L, 1000L}, 3L, 5);

        add(tests, "Large jump requires removing several old requests",
            new long[] {1L, 2L, 3L, 100L}, 5L, 3);

        add(tests, "Every request exactly one window apart",
            new long[] {0L, 10L, 20L, 30L}, 10L, 1);

        add(tests, "Duplicate groups exactly one window apart",
            new long[] {0L, 0L, 10L, 10L}, 10L, 2);

        add(tests, "One request on the excluded boundary",
            new long[] {0L, 1L, 10L}, 10L, 2);

        add(tests, "Requests just inside and exactly on boundaries",
            new long[] {0L, 1L, 9L, 10L}, 10L, 3);

        add(tests, "Old cluster entirely leaves the window",
            new long[] {0L, 1L, 2L, 50L, 51L}, 3L, 3);

        add(tests, "Overlapping candidate windows",
            new long[] {1L, 4L, 5L, 8L, 9L, 10L}, 6L, 4);

        add(tests, "Nonuniform gaps and growing bursts",
            new long[] {0L, 3L, 6L, 7L, 8L}, 5L, 3);

        add(tests, "Duplicate requests at time zero",
            new long[] {0L, 0L, 0L, 1L}, 1L, 3);

        add(tests, "Different duplicate-group sizes",
            new long[] {0L, 0L, 0L, 10L, 10L, 10L, 10L, 20L}, 10L, 4);

        add(tests, "Timestamps cross Integer.MAX_VALUE",
            new long[] {2147483646L, 2147483647L, 2147483648L, 2147483649L}, 3L, 3);

        add(tests, "All timestamps exceed int range",
            new long[] {3000000000L, 3000000001L, 3000000002L}, 2L, 2);

        add(tests, "Window boundaries near maximum timestamp",
            new long[] {999999999990L, 999999999999L, 1000000000000L}, 10L, 2);

        add(tests, "Duplicates near maximum timestamp",
            new long[] {999999999999L, 1000000000000L, 1000000000000L}, 1L, 2);

        add(tests, "Huge gaps between requests",
            new long[] {0L, 500000000000L, 1000000000000L}, 1000000000L, 1);

        add(tests, "Maximum window with exact boundary separation",
            new long[] {0L, 999999999L, 1000000000L}, 1000000000L, 2);

        add(tests, "Window left boundary is below zero",
            new long[] {0L, 1L, 2L}, 1000000000L, 3);

        add(tests, "Huge jump followed by a compact burst",
            new long[] {0L, 0L, 999999999998L, 999999999999L, 1000000000000L}, 3L, 3);

        add(tests, "Repeated maximum timestamp",
            new long[] {1000000000000L, 1000000000000L, 1000000000000L, 1000000000000L}, 1000000000L, 4);

        add(tests, "Window of two with consecutive arrivals",
            new long[] {1L, 2L, 3L, 4L}, 2L, 2);

        add(tests, "Duplicates spread over adjacent timestamps",
            new long[] {1L, 1L, 2L, 2L, 3L, 3L}, 2L, 4);

        add(tests, "Regular spacing with excluded left boundary",
            new long[] {0L, 2L, 4L, 6L, 8L}, 4L, 2);

        add(tests, "Middle peak followed by an isolated final request",
            new long[] {0L, 10L, 10L, 10L, 11L, 12L, 100L}, 3L, 5);

        add(tests, "Consecutive arrivals with a four-unit window",
            new long[] {5L, 6L, 7L, 8L, 9L}, 4L, 4);

        if (RUN_LARGE_TESTS) {
            add(tests, "Large: 200,000 identical maximum timestamps",
                repeated(200_000, 1_000_000_000_000L), 1L, 200_000);

            add(tests, "Large: 200,000 consecutive arrivals, window 1,000",
                arithmeticSequence(200_000, 0L, 1L), 1_000L, 1_000);

            add(tests, "Large: one window covers all 200,000 arrivals",
                arithmeticSequence(200_000, 0L, 1L), 1_000_000_000L, 200_000);

            add(tests, "Large: 200,000 arrivals exactly one window apart",
                arithmeticSequence(200_000, 0L, 5_000_000L), 5_000_000L, 1);

            add(tests, "Large: duplicate groups exactly one window apart",
                groupedRequests(1_000, 200, 10L), 10L, 200);

            add(tests, "Large: window includes two consecutive duplicate groups",
                groupedRequests(1_000, 200, 10L), 11L, 400);
        }

        return tests;
    }

    private static void add(
            List<TestCase> tests, String name,
            long[] timestamps, long window, int expected) {
        tests.add(new TestCase(name, timestamps, window, expected));
    }

    private static final class TestCase {
        final String name;
        final long[] timestamps;
        final long window;
        final int expected;

        TestCase(String name, long[] timestamps, long window, int expected) {
            this.name = name;
            this.timestamps = timestamps;
            this.window = window;
            this.expected = expected;
        }
    }

    // Test-fixture builders: these only create predetermined input arrays.

    private static long[] repeated(int count, long timestamp) {
        long[] result = new long[count];
        Arrays.fill(result, timestamp);
        return result;
    }

    private static long[] arithmeticSequence(int count, long first, long step) {
        long[] result = new long[count];
        for (int i = 0; i < count; i++) {
            result[i] = first + (long) i * step;
        }
        return result;
    }

    private static long[] groupedRequests(
            int groupCount, int requestsPerGroup, long gap) {
        long[] result = new long[groupCount * requestsPerGroup];
        int index = 0;
        for (int group = 0; group < groupCount; group++) {
            for (int j = 0; j < requestsPerGroup; j++) {
                result[index++] = (long) group * gap;
            }
        }
        return result;
    }

    private static String describe(long[] timestamps) {
        if (timestamps.length <= 18) {
            return Arrays.toString(timestamps);
        }
        return Arrays.toString(Arrays.copyOfRange(timestamps, 0, 6))
            + " ... "
            + Arrays.toString(Arrays.copyOfRange(
                timestamps, timestamps.length - 6, timestamps.length))
            + " (length=" + timestamps.length + ")";
    }
}

