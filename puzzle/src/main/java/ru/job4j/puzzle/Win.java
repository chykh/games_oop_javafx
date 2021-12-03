package ru.job4j.puzzle;

public class Win {
    public Win() {
    }

    public static boolean check(int[][] board) {
        return checkHor(board) || checkVert(board);
    }

    public static boolean checkHor(int[][] board) {
        boolean rsl = false;

        for(int i = 0; i < board.length; ++i) {
            if (board[i][0] != 0 && board[i][1] != 0 && board[i][2] != 0 && board[i][3] != 0 && board[i][4] != 0) {
                rsl = true;
                break;
            }
        }

        return rsl;
    }

    public static boolean checkVert(int[][] board) {
        boolean rsl = false;

        for(int i = 0; i < board[0].length; ++i) {
            if (board[0][i] != 0 && board[1][i] != 0 && board[2][i] != 0 && board[3][i] != 0 && board[4][i] != 0) {
                rsl = true;
                break;
            }
        }

        return rsl;
    }
}