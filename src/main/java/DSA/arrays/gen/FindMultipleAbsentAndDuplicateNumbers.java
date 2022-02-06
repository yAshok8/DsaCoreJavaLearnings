package DSA.arrays.gen;

import java.util.*;

class FindMultipleAbsentAndDuplicateNumbers {
    public static void main(String[] args){
        int [] targetArray = {3, 1, 3, 2, 2, 3, 1};
        System.out.println(Arrays.toString(targetArray));
        arrangeArrayElements(targetArray);
        printMissingAndDuplicateNumbers(targetArray);
    }

    private static void printMissingAndDuplicateNumbers(int[] targetArray) {
        int index = 0;
        Set<Integer> dupes = new HashSet<>();
        List<Integer> missingNumbers = new ArrayList<>();
        for (int elem : targetArray) {
            if (elem != index+1) {
                missingNumbers.add(index+1);
                dupes.add(elem);
            }
            index++;
        }
        System.out.println("Duplicate : "+dupes);
        System.out.println("Missing : "+missingNumbers);
    }

    private static void arrangeArrayElements(int [] targetArray) {
        int index = 0;
        while(index < targetArray.length){
            if(targetArray[targetArray[index]-1] != targetArray[index]){
                int temp = targetArray[index];
                targetArray[index] = targetArray[targetArray[index]-1];
                targetArray[temp-1] = temp;
            } else {
                index++;
            }
        }
    }
}