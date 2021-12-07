package ru.job4j.puzzle;

public class Win {
    public Win() {
    }

    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (checkHor(board, i) || checkVert(board, i)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkHor(int[][] board, int i) {
        boolean rsl = true;
        for (int j = 0; j < board[0].length; j++) {
            if (board[j][i] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean checkVert(int[][] board, int i) {
            boolean rsl = true;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 1) {
                    rsl = false;
                    break;
                }
            }
            return rsl;
        }
}