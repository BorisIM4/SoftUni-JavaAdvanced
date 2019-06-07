package L2_Multidimentional_Arrays_exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P4_Maximal_Sum_2 {

    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRows = scanner.nextInt();
        int numberOfColums = scanner.nextInt();
        scanner.nextLine();

        matrix = new int[numberOfRows][numberOfColums];

        for (int rows = 0; rows < numberOfRows; rows++) {
            matrix[rows] = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int maxSum = -1;
        int rowIndex = -1;
        int colIndex = -1;
        for (int row = 1; row < numberOfRows - 1; row++) {
            for (int col = 1; col < numberOfColums - 1; col++) {
                int currentSum = getMatrixSum(row, col);

                if (currentSum > maxSum){
                    maxSum = currentSum;
                    rowIndex = row;
                    colIndex = col;

                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printMatrixByGivenCell(rowIndex, colIndex);

    }

    private static void printMatrixByGivenCell(int rowIndex, int colIndex) {

        if (rowIndex == - 1 || colIndex == - 1){
            System.out.println("Result Not Found!");
        } else {
            int beginRow = rowIndex - 1;
            int beginCol = colIndex - 1;

            for (int r = beginRow; r < beginRow + 3; r++) {
                for (int c = beginCol; c < beginCol + 3; c++) {
                    System.out.print(matrix[r][c] + " ");
                }
                System.out.println();
            }
        }

    }

    private static int getMatrixSum(int row, int col) {
        int sum = 0;

        sum += matrix[row][col];
        sum += matrix[row - 1][col];
        sum += matrix[row][col - 1];
        sum += matrix[row + 1][col];
        sum += matrix[row][col + 1];
        sum += matrix[row - 1][col - 1];
        sum += matrix[row + 1][col + 1];
        sum += matrix[row - 1][col + 1];
        sum += matrix[row+ 1][col - 1];

        return  sum;

    }
}
