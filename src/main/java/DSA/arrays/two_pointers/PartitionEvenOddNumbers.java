package DSA.arrays.two_pointers;

public class PartitionEvenOddNumbers {

    public static void main(String[] args) {
        int [] arr = {6, 2, 8, 1, 4, 3, 12, 15, 17, 0, 21, 18};
        for (int elem: arr)
            System.out.print(elem + " ");
        System.out.println();
        partitionEvenAndOdds(arr);
    }

    private static void partitionEvenAndOdds(int [] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (arr[left] % 2 != 0) left++;
            while (arr[right] % 2 == 0) right--;

            //swap the left with right
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for (int elem: arr)
            System.out.print(elem+" ");
    }

}
