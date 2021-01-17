package L2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P3_Intersection_of_two_Matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int colums = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][colums];
        char[][] secondtMatrix = new char[rows][colums];

        for (int row = 0; row < rows; row++) {
            firstMatrix[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        for (int row = 0; row < rows; row++) {
            secondtMatrix[row] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }

        char[][] finalMatrix = new char[rows][colums];

        for (int row = 0; row < rows; row++) {
            for (int colum = 0; colum < colums; colum++) {
                char firstSymbol = firstMatrix[row][colum];
                char secondSymbol = secondtMatrix[row][colum];
                finalMatrix[row][colum] = firstSymbol == secondSymbol ? firstSymbol : '*';
            }
        }

        printMatrix(finalMatrix);

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

    private static void printMatrix(char[][] matrix) {
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
