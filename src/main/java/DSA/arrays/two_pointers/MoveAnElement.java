package DSA.arrays.two_pointers;

import java.util.Arrays;

class MoveAnElement {

    public static void main(String[] args) {
//        int num = removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        int[] arr1 = new int[]{3, 2, 2, 3};
        int num = removeElement(arr1, 3);
        System.out.println(Arrays.toString(arr1) + " " + num);
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val && nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            if (nums[i] != val) i++;
            if (nums[j] == val) j--;
        }
        return i;
    }
}