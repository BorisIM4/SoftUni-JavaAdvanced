package L2_Multidimensional_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P4_Sum_Matrix_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getDimensions(scanner);

        int numberOfRows = dimensions[0];
        int numberOfColums = dimensions[1];

        int[][] matrix = new int[numberOfRows][numberOfColums];

        int counter = 0;
        for (int row = 0; row < numberOfRows; row++) {
            int[] tokens = getDimensions(scanner);
            for (int colum = 0; colum < numberOfColums; colum++) {
                int element = tokens[colum];
                counter += element;
                matrix[row][colum] = element;
            }

        }

        System.out.printf("%d%n%d%n%d%n", numberOfRows
                , numberOfColums
                , counter);
    }

    private static int[] getDimensions(Scanner scanner) {
        return Arrays
                .stream(scanner
                        .nextLine()
                        .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
