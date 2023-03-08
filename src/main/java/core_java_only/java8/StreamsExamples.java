package core_java_only.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExamples {
    public static void main(String[] args) {
        System.out.println("sumOfSquareOfOdd() => "+sumOfSquareOfOdd());
        System.out.println("checkIfNoGreaterThan10Exists() => "+checkIfNoGreaterThan10Exists());
        System.out.println("findAllEvenNums() => "+findAllEvenNums());
        System.out.println("findAnyNegativeMatchedNum() => "+findAnyNegativeMatchedNum());
        System.out.println("countNumsInArr() => "+findAnyNegativeMatchedNum());
        System.out.println("findFirstElementOfNumArray() => "+findFirstElementOfNumArray());
        System.out.println("findMaxIntNum() => "+findMaxIntNum());
        System.out.println("findMinIntNum()  => "+findMinIntNum());
        System.out.println("countNumsInArr()  => "+countNumsInArr());
        System.out.println("secondMaxInteger()  => "+secondMaxInterger());
        System.out.println("findMaxFrequentElementInArray()  => "+findMaxFrequentElementInArray());
        System.out.println("mergeTwoSortedArrays()  => " + mergeTwoSortedArrays(new String[]{"1", "3", "5"}, new String[]{"2", "4"}));
        System.out.println("filterAndMapEvenNumAndSquare() " + filterAndMapEvenNumAndSquare(new int[]{1, 2, 3, 4, 5}));
        System.out.println("joinStrings()  => " + joinStrings(new String[]{ "Ashok", "Birju", "Yadav"}));
        System.out.println("Calling sortingArrayWithStreams()");
        sortingArrayWithStreams();
        System.out.println("Calling findDistinctNumbersFromArray() ");
        findDistinctNumbersFromArray();
        System.out.println("Calling forEachDemo() ");
        forEachDemo();
    }

    /**
     * Create a map of even number and their square
     *
     * @param ints input
     * @return map
     */
    private static Map<Integer, Integer> filterAndMapEvenNumAndSquare(int[] ints) {
        return Arrays.stream(ints).boxed()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toMap(Function.identity(), n -> n*n));
    }

    private static String joinStrings(String[] inputStringArray) {
        return Arrays.stream(inputStringArray).collect(Collectors.joining(" "));
    }

    private static List<String> mergeTwoSortedArrays(String [] arr1, String [] arr2) {
        String[] ans = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray(String[]::new);
        return Arrays.asList(ans);
    }


    private static int findMaxFrequentElementInArray() {
        int [] elems = new int[] {1,5,5,5,5,5,2,2,4,4,4,4,3,3,3};
        Map<Integer, Long> occurrences = Arrays.stream(elems).boxed()
                // Group the elements by their value and count them
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return occurrences.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    private static int secondMaxInterger() {
        List<Integer> numList = Arrays.asList(1, 3, 4, 5, -1, -5, 6, 6, 0, 2);
        return numList.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
    }

    private static int sumOfSquareOfOdd() {
        return IntStream.range(1,10).filter(n->n%2!=0).map(n->n*n).sum();
    }

    private static boolean checkIfNoGreaterThan10Exists(){
        return IntStream.range(5,12).anyMatch(num->num>10);
    }

    private static boolean findAllEvenNums(){
        return IntStream.rangeClosed(1,10)
                .filter(num->num%2==0).boxed().collect(Collectors.toList())
                .stream().allMatch(num -> num%2==0);
    }

    private static int findAnyNegativeMatchedNum(){
        OptionalInt res = IntStream.range(-10,11).filter(num -> num<0).findAny();
        return res.isPresent() ? res.getAsInt() : 0;
    }

    private static int countNumsInArr(){
        return (int) IntStream.range(0,10).count();
    }

    private static void findDistinctNumbersFromArray(){
        int [] dupElemArray = {1,1,2,2,2,1,4,2,4,5,1,4,6,7,2,2,2,4,6,7,9};
        System.out.println("Original Array : "+ Arrays.toString(dupElemArray));
        System.out.println("Distinct Elements of the Array : "+ Arrays.toString(Arrays.stream(dupElemArray).distinct().toArray()));
    }

    private static int findFirstElementOfNumArray(){
        OptionalInt optionalNum = IntStream.range(-11,21).findFirst();
        return optionalNum.isPresent() ? optionalNum.getAsInt() : -0;
    }

    private static void forEachDemo(){
        int [] elements = IntStream.range(0,5).toArray();
        Arrays.stream(elements).forEach(System.out::println);
    }

    private static int findMaxIntNum(){
        return Stream.of(-9, -18, 0, 25, 4).max(Integer::compare).get();
    }

    private static int findMinIntNum(){
        return Stream.of(-9, -18, 0, 25, 4).min(Integer::compare).get();
    }

    private static void sortingArrayWithStreams(){
        List<Integer> randomArray = Arrays.asList(21, -9, 1, -18, 0, 25, 4, 2);
        System.out.println(randomArray);
        List<Integer> sortedArray = randomArray.stream().sorted(Integer::compare).collect(Collectors.toList());
        System.out.println(sortedArray);
    }
}
