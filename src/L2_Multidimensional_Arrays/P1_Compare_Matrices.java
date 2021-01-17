package L2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P1_Compare_Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areNotEqual = firstMatrix.length != secondMatrix.length;

        if (!areNotEqual) {
            for (int row = 0; row < firstMatrix.length; row++) {
                int[] firsArr = firstMatrix[row];
                int[] secondArr = secondMatrix[row];
                areNotEqual = firsArr.length != secondArr.length;
                if (!areNotEqual) {
                    for (int col = 0; col < firsArr.length; col++) {
                        if (firsArr[col] != secondArr[col]) {
                            areNotEqual = true;
                            break;
                        }
                    }
                }
                if (areNotEqual) {
                    break;
                }

            }
        }

        String output = areNotEqual ? "not equal" : "equal";

        System.out.println(output);

    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndColums = readArray(scanner);
        int rows = rowsAndColums[0];
        int colums = rowsAndColums[1];

        int[][] matrix = new int[rows][colums];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner);
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int colum = 0; colum < matrix[row].length; colum++) {
                System.out.print(matrix[row][colum] + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
