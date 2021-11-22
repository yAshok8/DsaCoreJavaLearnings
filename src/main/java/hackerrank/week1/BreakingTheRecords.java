package hackerrank.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class BreakingTheRecordsResult {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int max = scores.get(0);
        int min = scores.get(0);
        int maxHitCount = 0;
        int minHitCount = 0;

        for (int i=1; i<scores.size(); i++) {
            if (scores.get(i) < min){
                minHitCount++;
                min = scores.get(i);
            }
            if (scores.get(i) > max){
                maxHitCount++;
                max = scores.get(i);
            }
        }

        return new ArrayList<>(Arrays.asList(maxHitCount, minHitCount));
    }

}

public class BreakingTheRecords {
    public static void main(String[] args) throws IOException {
//        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//            .collect(toList());
        List<Integer> scores = new ArrayList<>(Arrays.asList(10,5,20,20,4,5,2,25,1));
        List<Integer> result = BreakingTheRecordsResult.breakingRecords(scores);
        System.out.println(result);
    }
}
