package DSA;

public class TwoSortedArraysMedian {
    public static void main(String[] args) {
        int [] x = {3,5,9,13,18,21};
        int [] y = {8,9,15,19,35};
        int median = findMedian(x,y);
    }

    private static int findMedian(int[] x, int[] y) {
        int xl = 0, xh = x.length;
        int xy_l = x.length + y.length;
        while (xl < xh) {
            int xm = (xl + xh) / 2;
            int yi = (xy_l / 2 + 1) - xm;
            if(x[xm-1] < y[yi] && x[xm] > y[yi-1])
                break;
            else if(x[xm-1] > y[yi])
                xh = xm - 1;
            else
                xl = xm + 1;
        }
        System.out.println(xl+" "+xh);
        return 0;
    }
}
