package leetcode;

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
                int ptr = i;
                while(ptr > 0 && pattern.charAt(ptr-1) == 'D' && num[ptr] > num[ptr-1]) {
                    swap(ptr, ptr-1, num);
                    ptr--;
                }
            } else {
                int ptr = i;
                while(ptr > 0 && pattern.charAt(ptr-1) == 'I' && num[ptr] < num[ptr-1]) {
                    swap(ptr, ptr-1, num);
                    ptr--;
                }
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
}