package leetcode;

import java.util.ArrayList;
import java.util.List;

class LC51NQueens {

    List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        LC51NQueens nQueens = new LC51NQueens();
        nQueens.solveNQueens(8);
        for (List<String> s1: nQueens.ans) {
            for (String s2 : s1) {
                System.out.println(s2);
            }
            System.out.println();
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean [][] board = new boolean[n][n];
        solve(board, new ArrayList<>(), 0);
        return null;
    }

    private boolean solve(boolean[][] board, List<String> currStrList, int row) {
        if (row == board.length) {
            ans.add(new ArrayList<>(currStrList));
            return true;
        }
        boolean res = false;
        for (int col = 0; col<board[row].length; col++) {
            if (checkColumn(row,col,board) && checkDiagonal(row, col, board)) {
                board[row][col] = true;
                String currStr = getString(col, board[0].length);
                currStrList.add(currStr);
                res = solve(board, currStrList, row + 1);
                board[row][col] = false;
                currStrList.remove(currStr);
            }
        }
        return res;
    }

    private String getString(int index, int arrLen) {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<arrLen; i++) {
            if (index == i) {
                builder.append("Q");
            } else {
                builder.append("-");
            }
        }
        return builder.toString();
    }

    private boolean checkDiagonal(int row, int col, boolean [][] board) {
        int r = row;
        int c = col;
        for (;r>=0&&c>=0;r--,c--) {
            if(board[r][c]) {
                return false;
            }
        }
        r = row;
        c = col;
        for (;r>=0&&c<=board[0].length-1;r--,c++) {
            if(board[r][c]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int row, int col, boolean [][] board) {
        if (row==0)
            return true;
        for (int i=row-1; i>=0; i--) {
            if(board[i][col])
                return false;
        }
        return true;
    }

}
