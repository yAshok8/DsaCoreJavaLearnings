package leetcode;

@FunctionalInterface
interface FunctionalCharCheck {
    boolean checkPattern(String pattern, int index, int [] num);
}

class ConstructSmallestNumberFromDIStringLC2375 {
    public static void main(String[] args) {
        ConstructSmallestNumberFromDIStringLC2375 obj = new ConstructSmallestNumberFromDIStringLC2375();
        System.out.println(obj.smallestNumber("DDD"));
        System.out.println(obj.smallestNumber("IIIDIDDD"));
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