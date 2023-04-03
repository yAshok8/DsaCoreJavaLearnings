package interviewAsked;

public class SegregateNums_MediaNet_unfinished {
    public static void main(String[] args) {
        int [] nums = new int[] {2,2,1,1,0,1};
        segregate(nums);
    }

    private static void segregate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int currNum = 0;
        while (l<r) {
            if (nums[l] != currNum) {
                    //search for 0
                    while (r > l  && nums[r] != currNum){
                        r--;
                    }
                    if (l != r) {
                        int temp = nums[l];
                        nums[l] = nums[r];
                        nums[r] = temp;
                    } else {
                        currNum = 1;
                    }
                    l++;
                    r = nums.length - 1;
            } else {
                l++;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
