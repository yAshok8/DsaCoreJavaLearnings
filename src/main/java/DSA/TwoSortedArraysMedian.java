package DSA;

public class TwoSortedArraysMedian {
    public static void main(String[] args) {
//        int [] x = {3,5,13,18,21,23};
//        int [] y = {8,9,15,19,35,40};

        int [] x = {1,2,3,4,5,6};
        int [] y = {};
        double median = findMedian(x,y);
        System.out.println("\n Median: "+median);
    }

    private static double findMedian(int[] inputArr1, int[] inputArr2) {
        int x = inputArr1.length;
        int y = inputArr2.length;

        if(x>y)
            return findMedian(inputArr2, inputArr1);

        int low = 0;
        int high = x;

        while (low <= high){
            int partitionX = (low+high) / 2;
            int partitionY = (x+y+1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : inputArr1[partitionX-1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : inputArr1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : inputArr2[partitionY-1];
            int minRightY = (partitionY == y) ? Integer.MIN_VALUE : inputArr2[partitionY];

            if(maxLeftX <= minRightY && minRightX >= maxLeftY){
                if((x+y) % 2 == 0){
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                }else{
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }else if(maxLeftX > minRightY){
                high = partitionX - 1;
            }else{
                low = partitionX + 1;
            }
        }
        return 0;
    }

}
