package DSA.matrix;

public class Rotate90 {
    public static void main(String[] args) {
        char[][] mat = {{'1', 'k', '0'}, {'2', 'l', '7'}, {'3', 'm', '5'}};
        char[][] res_mat = new char[3][3];
        System.out.println("Before Rotation => ");
        printMatrix(mat);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res_mat[i][j] = mat[j][2 - i];
            }
        }
        System.out.println("After Rotation => ");
        printMatrix(res_mat);
    }

    private static void printMatrix(char mat[][]){
        for(int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                System.out.print(mat[r][c]+" ");
            }
            System.out.println();
        }
    }
}
