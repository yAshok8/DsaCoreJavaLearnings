package interviewAsked;

class Search2DSortedMatrix_Emirates {
    public static void main(String[] args) {
        int [][] _2DMat = new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println(searchMatrix(_2DMat, 3));
    }
    private static boolean searchMatrix(int[][] matrix, int target) {
        int f = 0;
        int width = matrix[0].length;
        int l = matrix.length * width - 1;
        while (f<=l) {
            int mid = (f + l) / 2;
            int i = mid / width;
            int j = mid % width;
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) {
                f = mid + 1;
            } else {
                l = mid-1;
            }
        }
        return false;        
    }
}