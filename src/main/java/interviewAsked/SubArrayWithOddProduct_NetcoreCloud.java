package interviewAsked;

/*

 */
public class SubArrayWithOddProduct_NetcoreCloud {
    public static void main(String[] args) {
        int [] inputArray = new int[]{1,3,5,7};
        System.out.println(countSubArrayWithOddProduct(inputArray, inputArray.length));
    }

    private static int countSubArrayWithOddProduct(int [] arr, int arrLen) {
        int last = -1;
        int count = 0;
        int currCalc = 0;
        for (int i=0; i<arrLen; i++) {
            if (arr[i] % 2 == 0) {
                currCalc = i - last -1;
                count += (currCalc * (currCalc + 1) / 2);
                last = i;
            }
        }
        currCalc = arrLen - last - 1;
        count += (currCalc * (currCalc + 1) / 2);
        return count;
    }

}
