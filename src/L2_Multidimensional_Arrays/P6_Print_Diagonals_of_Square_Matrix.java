package L2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P6_Print_Diagonals_of_Square_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            int[] elementInRow = Arrays
                    .stream(scanner
                            .nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int colum = 0; colum < elementInRow.length; colum++) {
                int currentElement = elementInRow[colum];
                matrix[row][colum] = currentElement;
            }
        }

        int[] diagonalOne = new int[matrixSize];
        int[] diagonalTwo = new int[matrixSize];

        for (int row = 0; row < matrix.length; row++) {
            for (int colum = 0; colum < matrix[row].length; colum++) {
                int currentElement = matrix[row][colum];
                if (row == colum) {
                    diagonalOne[row] = currentElement;
                }

                if (row + colum == matrix.length - 1) {
                    diagonalTwo[colum] = currentElement;
                }
            }
        }

//        for (int row = matrix.length - 1; row >= 0; row--) {
//            for (int colum = 0; colum < matrix[row].length; colum++) {
//                int currentElement = matrix[row][colum];
//                if (row + colum == matrixSize - 1) {
//                    diagonalTwo[colum] = currentElement;
//                }
//            }
//        }

        for (int element : diagonalOne) {
            System.out.print(element + " ");
        }
        System.out.println();
        for (int element : diagonalTwo) {
            System.out.print(element + " ");
        }

    }
}
