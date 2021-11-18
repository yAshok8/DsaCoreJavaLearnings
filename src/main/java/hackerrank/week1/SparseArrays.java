package hackerrank.week1;

import java.io.IOException;
import java.util.*;

class SparseArraysResult {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        Map<String, Integer> stringsFreq = new HashMap<>();
        for (String stringElem: strings){
            stringsFreq.put(stringElem, stringsFreq.getOrDefault(stringElem, 0) + 1);
        }
        List<Integer> queryStrFreq = new ArrayList<>();
        for (String query : queries){
            queryStrFreq.add(stringsFreq.getOrDefault(query, 0));
        }
        return queryStrFreq;
    }

}

public class SparseArrays {
    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>(Arrays.asList("ab", "ab", "abc"));
        List<String> queries = new ArrayList<>(Arrays.asList("ab", "abc", "bc"));

        List<Integer> res = SparseArraysResult.matchingStrings(strings, queries);
        System.out.println(res);
    }
}
