package DSA.matrix;

/*
Reshape the Matrix
In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a \
new one with a different size r x c keeping its original data.
You are given an m x n matrix mat and two integers r and c representing the number of
rows and the number of columns of the wanted reshaped matrix.
The reshaped matrix should be filled with all the elements of the original matrix in
the same row-traversing order as they were.
If the reshape operation with given parameters is possible and legal,
output the new reshaped matrix; Otherwise, output the original matrix.

Example:
Input Matrix:
1 2
3 4
5 6

Transformed mat is required to have only 2 rows and 3 columns.
Then the output matrix should be as below.
1 2 3
4 5 6

LeetCode URL: https://leetcode.com/problems/reshape-the-matrix/
*/

public class MatrixReshape {
    public static void main(String[] args) {
        int [][] srcMat = {{1,2}, {3,4}, {5,6}};
        int [][] resMat = matrixReshape(srcMat, 2, 3);
//        int [][] resMat = matrixReshape(srcMat, srcMat.length, srcMat[0].length);
        System.out.println("Source Matrix: ");
        for (int[] value : srcMat) {
            for (int j = 0; j < srcMat[0].length; j++) {
                System.out.print(value[j] + " ");
            }
            System.out.println();
        }
        System.out.println("Result Matrix: ");
        for (int[] ints : resMat) {
            for (int j = 0; j < resMat[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat[0].length * mat.length)
            return mat;

        int rt = 0;
        int ct = 0;

        int [][] resMat = new int[r][c];

        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[0].length; j++){
                if(ct == c){
                    ct = 0;
                    rt++;
                }
                resMat[rt][ct++] = mat[i][j];
            }
        }

        return resMat;
    }
}
