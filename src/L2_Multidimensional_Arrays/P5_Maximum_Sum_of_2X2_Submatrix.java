package L2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P5_Maximum_Sum_of_2X2_Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);

        int numberOfRows = dimensions[0];
        int numberOfColums = dimensions[1];

        int[][] matrix = new int[numberOfRows][numberOfColums];

        for (int row = 0; row < numberOfRows; row++) {
            int[] elementsInRow = readArray(scanner);
            for (int colum = 0; colum < numberOfColums; colum++) {
                int currentElement = elementsInRow[colum];
                matrix[row][colum] = currentElement;
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0, maxCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int colum = 0; colum < matrix[row].length - 1; colum++) {
                int sum = matrix[row][colum]
                        + matrix[row][colum+1]
                        + matrix[row+1][colum]
                        + matrix[row+1][colum+1];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = row;
                    maxCol = colum;
                }
            }
        }
        System.out.println(matrix[maxRow][maxCol] + " " + matrix[maxRow][maxCol + 1]);
        System.out.println(matrix[maxRow + 1][maxCol] + " " + matrix[maxRow + 1][maxCol + 1]);
        System.out.println(maxSum);
        

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays
                .stream(scanner
                        .nextLine()
                        .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
