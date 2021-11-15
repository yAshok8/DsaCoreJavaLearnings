package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        Map<String, Double> numMap = new HashMap<>();

        final String POSITIVE = "positive";
        final String NEGATIVE = "negative";
        final String ZERO = "zero";

        numMap.put(POSITIVE, 0.0);
        numMap.put(NEGATIVE, 0.0);
        numMap.put(ZERO, 0.0);
        for(int elem: arr){
            if (elem < 0){
                numMap.put(NEGATIVE, numMap.get("negative")+1);
            }else if (elem > 0){
                numMap.put(POSITIVE, numMap.get("positive")+1);
            }else {
                numMap.put(ZERO, numMap.get("zero")+1);
            }
        }
        System.out.println(String.format("%.6f", numMap.get(POSITIVE) / (arr.size() * 1.0)));
        System.out.println(String.format("%.6f", numMap.get(NEGATIVE) / (arr.size() * 1.0)));
        System.out.println(String.format("%.6f", numMap.get(ZERO) / (arr.size() * 1.0)));
    }

}

public class PositiveNegativeZeroRatios {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
