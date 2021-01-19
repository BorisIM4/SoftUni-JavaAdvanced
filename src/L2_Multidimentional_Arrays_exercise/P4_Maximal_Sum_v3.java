package L2_Multidimentional_Arrays_exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P4_Maximal_Sum_v3 {

    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensionsOfMatrix = Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfRows = dimensionsOfMatrix[0];
        int numberOfColums = dimensionsOfMatrix[1];

        int[][] matrix = new int[numberOfRows][numberOfColums];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays
                    .stream(scanner
                            .nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int bestSum = Integer.MIN_VALUE;
        int[] bestVector = new int[2];
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int[] start = new int[] {row, col};
                if (findSum(start, matrix) > bestSum) {
                    bestSum = findSum(start, matrix);
                    bestVector = start;
                }

            }
        }

        System.out.println(String.format("Sum = %d" ,bestSum));
        printMatrix(bestVector, matrix);

    }

    private static int findSum(int[] start, int[][] matrix) {
        int sum = 0;
        for (int row = start[0]; row < start[0] + 3; row++) {
            for (int col = start[1]; col < start[1] + 3; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static void printMatrix(int[] bestVector, int[][] matrix) {
        for (int row = bestVector[0]; row < bestVector[0] + 3; row++) {
            for (int col = bestVector[1]; col < bestVector[1] + 3; col++) {
                System.out.print(String.format("%d " ,matrix[row][col]));
            }
            System.out.println();
        }
    }
}
