package DSA.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {
    private List<List<Integer>> threeSum(int[] nums, int currentIndex, int targetNum) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = currentIndex; i < len - 2; i++) {
            if (i == currentIndex || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = len - 1;
                while (low < high) {
                    if (nums[low] + nums[high] + nums[i] == targetNum) {
                        //form a list
                        res.add(Arrays.asList(nums[low], nums[high], nums[i]));
                        while (low<high && nums[low] == nums[low + 1]) low++;
                        while (low<high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > (targetNum - nums[i])) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= len - 4; i++) {
            if ( i == 0 || nums[i] != nums[i-1] ){
                int targetNumIndex = i + 1;
                int targetNum = target - nums[i];
                List<List<Integer>> res2 =
                        threeSum(nums, targetNumIndex, targetNum);
                if (!res2.isEmpty())
                    addTargetToLists(res, res2, nums[i]);
            }
        }
        return res;
    }

    //-2, -1, 0, 0, 1, 2

    private void addTargetToLists(List<List<Integer>> res, List<List<Integer>> res2, int targetNum) {
        for(List<Integer> val : res2) {
            List<Integer> temp = new ArrayList<>();
            temp.add(targetNum);
            temp.addAll(val);
            Collections.sort(temp);
            res.add(temp);
        }
    }

    public static void main(String[] args) {

        FourSum fourSum = new FourSum();
//        int [] arr = {-3,-2,-1,0,0,1,2,3};
        int [] arr = {4,12,-34,21,22,-28,16,-16,0,-17,9,-5,-12,9,18,-5,-1,0,-13};
//        int [] arr = {1,0,-1,0,-2,2};
        List<List<Integer>> result = fourSum.fourSum(arr, 7);

        System.out.println(result);

    }

}
