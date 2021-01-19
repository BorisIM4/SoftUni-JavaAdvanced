package L2_Multidimentional_Arrays_exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P1_Fill_the_Matrix_v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");
        int dimentionOfMatrix = Integer.parseInt(tokens[0]);
        String typeOfMatrix = tokens[1];

        int[][] matrix = fillMatrix(dimentionOfMatrix, typeOfMatrix);
        printMatrix(matrix);

    }

    private static int[][] fillMatrix(int dimentionOfMatrix, String typeOfMatrix) {
        int[][]matrix = new int[dimentionOfMatrix][dimentionOfMatrix];
        if ("A".equals(typeOfMatrix)) {
            fillPatternA(matrix);
        } else if ("B".equals(typeOfMatrix)) {
            fillPatternB(matrix);
        }

        return matrix;
    }

    private static void fillPatternB(int[][] matrix) {
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[col][row] = number++;
                }
            } else {
                for (int col = matrix[row].length - 1; col >= 0; col--) {
                    matrix[col][row] = number++;
                }
            }

        }
    }

    private static void fillPatternA(int[][] matrix) {
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = number++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row: matrix) {
            for (int element:row) {
                System.out.print(String.format("%d " ,element));
            }
            System.out.println();
        }
    }
}
