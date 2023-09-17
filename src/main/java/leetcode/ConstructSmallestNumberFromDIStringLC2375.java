package leetcode;

import java.util.HashSet;

@FunctionalInterface
interface FunctionalCharCheck {
    boolean checkPattern(String pattern, int index, int [] num);
}

class ConstructSmallestNumberFromDIStringLC2375 {

    String ans = null;

    public static void main(String[] args) {
        ConstructSmallestNumberFromDIStringLC2375 obj = new ConstructSmallestNumberFromDIStringLC2375();
        System.out.println(obj.smallestNumber("ID"));
        obj.smallestNumberRecursiveDFS("ID");
        System.out.println();
        System.out.println(obj.smallestNumber("IIIDIDDD"));
        obj.smallestNumberRecursiveDFS("IIIDIDDD");
        System.out.println();
        System.out.println(obj.smallestNumber("IDID"));
        obj.smallestNumberRecursiveDFS("IDID");
        System.out.println();
        System.out.println(obj.smallestNumber("DIDDIDI"));
        obj.smallestNumberRecursiveDFS("DIDDIDI");

//        System.out.println(obj.ans);
    }

    private String smallestNumberRecursiveDFS(String pattern) {
        int [] nums = new int[pattern.length() + 1];
        dfs(nums, new HashSet<>(), 0, pattern);
        StringBuilder stringBuilder = new StringBuilder();
        for (int num: nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    private boolean dfs(int[] nums, HashSet<Object> set, int index, String pattern) {
        if (index == pattern.length() + 1) {
            return true;
        }
        boolean res = false;
        for (int i=1; i<=pattern.length() + 1; i++) {
            if (!set.contains(i)) {
                if (index > 0
                        && ((pattern.charAt(index-1) == 'I' && nums[index-1] > i)
                        || (pattern.charAt(index-1) == 'D' && nums[index-1] < i))) {
                    return false;
                }
                nums[index] = i;
                set.add(i);
                res = dfs(nums, set, index + 1, pattern);
                if (res) {
                    break;
                }
                nums[index] = 0;
                set.remove(i);
            }
        }
        return res;
    }

    public String smallestNumber(String pattern) {
        int n = pattern.length();
        int [] num = new int[n+1];
        for (int i=0; i<n+1; i++) {
            num[i] = i+1;
        }
        for (int i=1; i<=n; i++) {
            if (pattern.charAt(i-1) == 'D') {
                swapBacktrack((p, index, arr) -> pattern.charAt(index-1) == 'D' && num[index] > num[index-1], pattern, i, num);
            } else {
                swapBacktrack((p, index, arr) -> pattern.charAt(index-1) == 'I' && num[index] < num[index-1], pattern, i, num);
            }
        }
        StringBuilder stbr = new StringBuilder();
        for (int i=0; i<n+1; i++) {
            stbr.append(num[i]);
        }
        return stbr.toString();
    }

    private void swap(int l, int r, int [] num) {
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }

    private void swapBacktrack(FunctionalCharCheck callbackObj, String p, int index, int [] num) {
        while(index > 0 && callbackObj.checkPattern(p, index, num)) {
            swap(index, index-1, num);
            index--;
        }
    }
}