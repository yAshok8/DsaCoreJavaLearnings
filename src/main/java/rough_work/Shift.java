package rough_work;

public class Shift {
    public static void main(String[] args) {
        int [] arr = new int[]{1, -1, 2, -2};
        int p1 = 0;
        int p2 = arr.length - 1;

        while (p1 < p2) {
            if (arr[p1] < 0) p1++;
            if (arr[p2] > 0) p2--;
            if (p1 < p2) {
                int temp = arr[p2];
                arr[p2] = arr[p1];
                arr[p1] = temp;
            }
            p1++;
            p2--;
        }

        for (int elem: arr) {
            System.out.print(elem + " ");
        }
    }
}
