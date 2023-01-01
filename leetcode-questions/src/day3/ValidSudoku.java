package day3;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
//        String[][] sudoku = {
//                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
//                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
//                {".", "9", "8", ".", ".", ".", ".", "6", "."},
//                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
//                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
//                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
//                {".", "6", ".", ".", ".", ".", "2", "8", "."},
//                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
//                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
//        };
        String[][] sudoku = {
                {"8", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };

        Boolean output = isValidSudoku(sudoku);

        System.out.println("output = " + output);
    }

    private static Boolean isValidSudoku(String[][] sudoku) {
        return isColumnsValid(sudoku) && isRowsValid(sudoku) && isBlocksValid(sudoku);
    }

    private static boolean isBlocksValid(String[][] sudoku) {
        for (int i = 0; i < sudoku.length; i += 3) {
            for (int j = 0; j < sudoku[i].length; j += 3) {
                if (!isBlockValid(sudoku, i, j)) return false;
            }
        }
        return true;
    }

    private static boolean isBlockValid(String[][] sudoku, int i, int j) {
        String[] cells = new String[9];
        cells[0] = sudoku[i][j];
        cells[1] = sudoku[i][j + 1];
        cells[2] = sudoku[i][j + 2];
        cells[3] = sudoku[i + 1][j];
        cells[4] = sudoku[i + 1][j + 1];
        cells[5] = sudoku[i + 1][j + 2];
        cells[6] = sudoku[i + 2][j];
        cells[7] = sudoku[i + 2][j + 1];
        cells[8] = sudoku[i + 2][j + 2];

        Set<String> set = new HashSet<>();
        for (String cell : cells) {
            if (!cell.equalsIgnoreCase(".")) {
                if (!set.contains(cell)) {
                    set.add(cell);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isRowsValid(String[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            if (!isRowValid(sudoku[i])) return false;
        }

        return true;
    }

    private static Boolean isRowValid(String[] row) {
        Set<String> set = new HashSet<>();
        for (String symbol : row) {
            if (!symbol.equalsIgnoreCase(".")) {
                if (!set.contains(symbol)) {
                    set.add(symbol);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private static Boolean isColumnsValid(String[][] sudoku) {
        for (int j = 0; j < sudoku[0].length; j++) {
            if (!isColumnValid(sudoku, j)) return false;
        }

        return true;
    }

    private static Boolean isColumnValid(String[][] sudoku, int j) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < sudoku.length; i++) {
            if (!sudoku[i][j].equalsIgnoreCase(".")) {
                if (!set.contains(sudoku[i][j])) {
                    set.add(sudoku[i][j]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
