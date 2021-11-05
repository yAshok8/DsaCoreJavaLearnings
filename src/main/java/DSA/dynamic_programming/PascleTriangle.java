package DSA.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * for a given row number return a pascle triangle in the form of List<List<Integer>>
 * LeetCode URL: https://leetcode.com/problems/pascals-triangle/
 */

public class PascleTriangle {

    public static void main(String[] args) {
        List<List<Integer>> pascleTriangle = generate(5);
        System.out.println(pascleTriangle);
    }

    private static List<List<Integer>> generate(int numRows) {
        int [][] resMat = new int [numRows][numRows];
        resMat[0][0] = 1;
        for (int i=1; i<numRows; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    resMat[i][j] = 1;
                }else{
                    resMat[i][j] = resMat[i-1][j-1] + resMat[i-1][j];
                }
            }
        }
        List<List<Integer>> finalList = new ArrayList<>();
        for(int i=0; i<resMat.length; i++){
            List<Integer> rowList = new ArrayList<>();
            for(int j=0; j<=i; j++){
                rowList.add(resMat[i][j]);
            }
            finalList.add(rowList);
        }

        return finalList;
    }
}
