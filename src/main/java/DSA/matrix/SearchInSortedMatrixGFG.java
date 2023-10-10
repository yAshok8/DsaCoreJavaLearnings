package DSA.matrix;

public class SearchInSortedMatrixGFG {
  
    public static void main(String[] args) {
        int [][] mat = new int[][] {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        System.out.println((searchIn2DSortedArrayGFG(mat,4,4,27)) ? "Element is present." : "Element is absent.");
        System.out.println((searchIn2DSortedArrayGFG(mat,4,4,50)) ? "Element is present." : "Element is absent.");
        System.out.println((searchIn2DSortedArrayGFG(mat,4,4,10)) ? "Element is present." : "Element is absent.");
        System.out.println((searchIn2DSortedArrayGFG(mat,4,4,28)) ? "Element is present." : "Element is absent.");
        System.out.println((searchIn2DSortedArrayGFG(new int[][]{{3,30,38},{36,43,60},{40,51,69}},3,3,62)) ? "Element is present." : "Element is absent.");
        System.out.println((searchIn2DSortedArrayGFG(new int[][]{{3,30,38},{36,43,60},{40,51,69}},3,3,51)) ? "Element is present." : "Element is absent.");
        System.out.println((searchIn2DSortedArrayGFG(new int[][]{{3,30,38},{36,43,60},{40,51,69}},3,3,-1)) ? "Element is present." : "Element is absent.");
        System.out.println((searchIn2DSortedArrayGFG(new int[][]{{1,3}},1,2,3)) ? "Element is present." : "Element is absent.");
        System.out.println((searchIn2DSortedArrayGFG(new int[][]{{1,3}},1,2,2)) ? "Element is present." : "Element is absent.");
        System.out.println((searchIn2DSortedArrayGFG(new int[][]{{1,3}},1,2,-1)) ? "Element is present." : "Element is absent.");
    }
  
    private static boolean searchIn2DSortedArrayGFG(int [][] matrix, int n, int m, int target) {
        int r=0, c=m-1;
        while (c>=0 && r<n) {
            if (matrix[r][c] == target) return true;
            if (target < matrix[r][c]) {
                c--;
            } else {
                if (r==n-1) break;
                if (matrix[r+1][c] > target) {
                    c--;
                } else {
                    r++;
                }
            }
        }
        return false;
    }
}
