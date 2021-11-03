package DSA.arrays.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int [] num1 = {9,4,9,8,4};
        int [] num2 = {4,9,5};

        int [] res = intersect(num1, num2);
        for(int elem: res)
            System.out.print(elem + " ");

    }

    private static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        Map<Integer, Integer> elemsCount = new HashMap<>();
        for (int elem: nums1)
            elemsCount.put(elem, elemsCount.getOrDefault(elem, 0) + 1);

        List<Integer> intersectionElems = new ArrayList<>();
        for (int elem: nums2){
            if (elemsCount.containsKey(elem) && elemsCount.get(elem) > 0){
                intersectionElems.add(elem);
                elemsCount.put(elem, elemsCount.get(elem)-1);
            }
        }

        int [] resArr = new int[intersectionElems.size()];
        int k = 0;
        for (int elem: intersectionElems){
            resArr[k++] = elem;
        }

        return resArr;
    }
}
