package L10_Exam_Preparation_Two.Exam_2019_10_26.P2_Book_Worm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[matrixSize][matrixSize];

        int startRow = -1;
        int startColum = -1;

        for (int row = 0; row < matrixSize; row++) {
            String[] tokens = scanner.nextLine().split("");
            for (int colum = 0; colum < matrixSize; colum++) {
                matrix[row][colum] = tokens[colum];
                if ("P".equals(tokens[colum])) {
                    startRow = row;
                    startColum = colum;
                }
            }
        }

        String line = "";
        while (!"end".equals(line = scanner.nextLine())) {

            if (line.equals("up")) {
                // goes Up
                if (isOutOfBounds(startRow - 1, startColum, matrix)) {
                    //it is out of bounds
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                } else {
                    // it is in bounds
                    matrix[startRow][startColum] = "-";
                    startRow = startRow - 1;
                    if (isNotDash(startRow, startColum, matrix)) {
                        stringBuilder.append(matrix[startRow][startColum]);
                    }
                    matrix[startRow][startColum] = "P";
                }
            } else if (line.equals("down")) {
                //goes down
                if (isOutOfBounds(startRow + 1, startColum, matrix)) {
                    //it is out of bounds
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                } else {
                    // it is in bounds
                    matrix[startRow][startColum] = "-";
                    startRow = startRow + 1;
                    if (isNotDash(startRow, startColum, matrix)) {
                        stringBuilder.append(matrix[startRow][startColum]);
                    }
                    matrix[startRow][startColum] = "P";
                }
            } else if (line.equals("left")) {
                //goes left
                if (isOutOfBounds(startRow, startColum - 1, matrix)) {
                    //it is out of bounds
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                } else {
                    // it is in bounds
                    matrix[startRow][startColum] = "-";
                    startColum = startColum - 1;
                    if (isNotDash(startRow, startColum, matrix)) {
                        stringBuilder.append(matrix[startRow][startColum]);
                    }
                    matrix[startRow][startColum] = "P";
                }
            } else if (line.equals("right")) {
                //goes right
                if (isOutOfBounds(startRow, startColum + 1, matrix)) {
                    //it is out of bounds
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                } else {
                    // it is in bounds
                    matrix[startRow][startColum] = "-";
                    startColum = startColum + 1;
                    if (isNotDash(startRow, startColum, matrix)) {
                        stringBuilder.append(matrix[startRow][startColum]);
                    }
                    matrix[startRow][startColum] = "P";
                }
            }
        }
        System.out.println(stringBuilder);
        printMatrix(matrix);

    }

    private static boolean isNotDash(int row, int colum, String[][] matrix) {
        return !matrix[row][colum].equals("-");
    }

    private static boolean isOutOfBounds(int row, int col, String[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
