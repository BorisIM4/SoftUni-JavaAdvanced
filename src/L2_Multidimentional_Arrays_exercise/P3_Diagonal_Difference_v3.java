package L2_Multidimentional_Arrays_exercise;

import java.util.Scanner;

public class P3_Diagonal_Difference_v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int squareMatrixDimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[squareMatrixDimension][squareMatrixDimension];

        for (int row = 0; row < squareMatrixDimension; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int colum = 0; colum < squareMatrixDimension; colum++) {
                int currentElement = Integer.parseInt(tokens[colum]);
                matrix[row][colum] = currentElement;

            }
        }

        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        for (int row = 0; row < squareMatrixDimension; row++) {
            for (int colum = 0; colum < squareMatrixDimension; colum++) {

                if (row == colum) {
                    int currentElement = matrix[row][colum];
                    firstDiagonalSum += currentElement;
                }

            }
        }

        for (int row = 0; row < squareMatrixDimension; row++) {
            for (int colum = 0; colum < squareMatrixDimension; colum++) {

                if (row + colum == squareMatrixDimension - 1) {
                    int currentElement = matrix[row][colum];
                    secondDiagonalSum += currentElement;
                }

            }
        }

        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }
}
