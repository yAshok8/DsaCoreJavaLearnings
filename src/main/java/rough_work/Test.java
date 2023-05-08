package rough_work;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        int target = 10;
        System.out.println(checkPairExists(arr, target));
    }

    private static boolean checkPairExists(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int elem: arr) {
            set.add(elem);
            if (set.contains(target - elem)) {
                return true;
            }
        }
        return false;
    }
}
