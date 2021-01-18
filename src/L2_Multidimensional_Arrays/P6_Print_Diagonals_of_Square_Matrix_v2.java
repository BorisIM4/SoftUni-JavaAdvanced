package L2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P6_Print_Diagonals_of_Square_Matrix_v2 {
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

        int row = 0, col = 0;

        while (row < matrixSize && col < matrixSize) {
            System.out.print(matrix[row++][col++] + " ");
        }
        System.out.println();
        int row2 = matrixSize - 1, col2 = 0;
        while (row2 >= 0 && col2 < matrixSize) {
            System.out.print(matrix[row2--][col2++] + " ");
        }

    }
}
