package DSA.matrix;

public class Rotate90 {
    public static void main(String[] args) {
        char mat[][] = {{'1', 'k', '0'}, {'2', 'l', '7'}, {'3', 'm', '5'}};
        System.out.println("Before Rotation => ");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(mat[r][c] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char temp = mat[i][j];
                mat[i][j] = mat[j][2 - i];
                mat[j][2 - i] = temp;
            }
        }
        System.out.println("After Rotation => ");
        for(int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                System.out.print(mat[r][c]+" ");
            }
            System.out.println();
        }
    }
}
