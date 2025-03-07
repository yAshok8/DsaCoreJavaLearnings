package rough_work;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        for (int i=1; i<=100; i++) {
//            if(isPrime(i)) {
//                System.out.println(i);
//            }
//        }
/*
        int [][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for (int i=0; i<=2; i++) {
            for (int j=2; j>=0; j--) {
                System.out.print(mat[j][i] + " ");
            }
            System.out.println();
        }*/

        Map<String, List<String>> keys = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();

        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        for (String str: strs) {
            char [] chars = str.toCharArray();
            Arrays.sort(chars);
            StringBuilder s1 = new StringBuilder();
            for (char c : chars) {
                s1.append(c);
            }
            if (keys.containsKey(s1.toString())) {
                keys.get(s1.toString()).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                keys.put(s1.toString(), list);
            }
        }
        System.out.println(keys);
    }

    private static boolean isPrime(final int num) {
        if (num == 1)
            return true;
        for (int i=2; i<=num/2; i+=2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
