package rough_work;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        int ans = nums.stream().filter(num -> num%2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(ans);
    }


}
