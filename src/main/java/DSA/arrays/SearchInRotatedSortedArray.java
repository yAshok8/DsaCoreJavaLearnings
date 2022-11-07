package DSA.arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
//        int [] elems = new int[] {19, 20, 22, 23, 45, 3, 9, 14, 18};
        int [] elems = new int[] { 9, 14, 18, 19, 20, 22, 23, 45, 3};
        int start = 0;
        int end = elems.length - 1;
        int size = elems.length;
        int r = 8;
        int targetNum = 45;
        while (start <= end) {
            int mid = (start + end) / 2;
            int resIndex = (mid + r) % size;
            if (elems[resIndex] == targetNum) {
                System.out.println("Found");
                break;
            }
            if (targetNum < elems[resIndex])
                end = mid - 1;
            else
                start = mid + 1;
        }
        if (end < start)
            System.out.println("not found");
    }


}
