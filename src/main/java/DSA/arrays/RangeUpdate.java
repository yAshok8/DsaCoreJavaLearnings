package DSA.arrays;

/**
 * For the given an array, you will be provided an update function as below.
 * update(i, j, num)
 * This function adds num to all elements of the array from index i to j inclusive.
 * Like this you will be provided with many (more than 1) update() function.
 * You have to send the final array after every update.
 *
 * Note: For every update function you can traverse 2 ranges in the array and add num to all.
 * This will be linear approach for every update function. For all updates it will be O(n^2).
 *
 * This can be optimized. Watch this video to know how or you can go through the optimal code.
 *
 * <a href="https://www.udemy.com/course/the-bible-of-algorithms-and-interview-questions/learn/lecture/16297872#overview">Udemy Video</a>
 *
 */
public class RangeUpdate {
    private static int [] TEMP_ARRAY;

    public static void main(String[] args) {
        int [] array = {7, -2, 3, 9, -11, 5, 1, -3};
        TEMP_ARRAY = new int[array.length];
        update(2, 6, 5);
        update(3, 7, 2);
        update(1, 5, -1);

        updateTempToFinalArray(array);
        printFinalArray(array);
    }

    private static void printFinalArray(int[] array) {
        for (int i=0; i<TEMP_ARRAY.length; i++) {
            array[i] += TEMP_ARRAY[i];
            System.out.print(array[i] + " ");
        }
    }

    private static void updateTempToFinalArray(int[] array) {
        for (int i=1; i<TEMP_ARRAY.length; i++) {
            TEMP_ARRAY[i] += TEMP_ARRAY[i-1];
        }
    }

    /**
     * To update intermediate array.
     * @param i the left index
     * @param j the right index
     * @param num the num to be added.
     */
    private static void update(int i, int j, int num) {
        TEMP_ARRAY[i] += num;
        if(j+1 < TEMP_ARRAY.length)
            TEMP_ARRAY[j+1] -= num;
    }


}
