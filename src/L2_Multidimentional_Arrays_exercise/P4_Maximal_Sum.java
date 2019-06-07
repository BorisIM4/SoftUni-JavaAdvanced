package L2_Multidimentional_Arrays_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P4_Maximal_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int numberOfRows = Integer.parseInt(input[0]);
        int numberOfColums = Integer.parseInt(input[1]);

        int[][] matrix = new int[numberOfRows][numberOfColums];

        for (int rows = 0; rows < numberOfRows; rows++) {
            int[] elementOfThatRow = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int colums = 0; colums < numberOfColums; colums++) {
                matrix[rows][colums] = elementOfThatRow[colums];
            }
        }

        int size = 3;

        int[][] controlMatrix = new int[size][size];



        for (int rows = 0; rows < size; rows++) {
            for (int colums = 0; colums < size; colums++) {
                controlMatrix[rows][colums] = matrix[rows][colums];
            }
        }

        System.out.println();
    }
}
