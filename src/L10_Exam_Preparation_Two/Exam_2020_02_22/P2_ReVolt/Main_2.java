package L10_Exam_Preparation_Two.Exam_2020_02_22.P2_ReVolt;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


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