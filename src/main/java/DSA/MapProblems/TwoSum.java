package DSA.MapProblems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int [] nums = {3,2,4};
        int target = 6;
        int [] res = twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int indexes [] = new int[2];
        Map<Integer, Integer> numsIndex = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!numsIndex.containsKey(target-nums[i])){
                numsIndex.put(nums[i], i);
            }else{
                indexes[0] = numsIndex.get(target-nums[i]);
                indexes[1] = i;
                break;
            }
        }
        return indexes;
    }
}
