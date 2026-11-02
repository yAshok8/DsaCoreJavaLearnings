package DSA.bitwise;

public class LC2571MinOpToReduceNumToZero {
    public static void main(String[] args) {
        System.out.println(approach1(8));
        System.out.println(approach1(9));
        System.out.println(approach1(26));
        System.out.println(approach2(8));
        System.out.println(approach2(9));
        System.out.println(approach2(26));
    }

    private static int approach1(int n) {
        int opCount = 0;
        while (n>0) {
            if (n%2 == 0) {
                n /= 2;
            } else {
                if (n % 4 == 3) n += 1;
                else n -= 1;
                opCount++;
            }
        }
        return opCount;
    }

    private static int approach2(int n) {
        if ((n & (n-1)) == 0) return 1;  //to know if number is positive power of 2
        while (n%2==0) n >>= 1; //bitwise right shift to trail rightmost zeros
        return 1 + Math.min(approach2(n+1), approach2(n-1));
    }
}
