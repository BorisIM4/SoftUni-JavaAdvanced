package L2_Multidimentional_Arrays_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P5_Matrix_shuffling_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numberOfRows = matrixDimensions[0];
        int numberOfColums = matrixDimensions[1];

        String[][] matrix = new String[numberOfRows][numberOfColums];

        for (int row = 0; row < numberOfRows; row++) {
            String[] elementInRow = scanner.nextLine().split("\\s+");
            for (int colum = 0; colum < elementInRow.length; colum++) {
                String element = elementInRow[colum];
                matrix[row][colum] = element;

            }
        }

        String line = "";
        while (!"END".equals(line = scanner.nextLine())) {
            String command = line.split("\\s+")[0];
            if (!("swap").equals(command) || line.split("\\s+").length > 5) {
                System.out.println("Invalid input!");

            } else {
                int firstElementRow = Integer.parseInt(line.split("\\s+")[1]);
                int firstElementColum = Integer.parseInt(line.split("\\s+")[2]);

                int secondElementRow = Integer.parseInt(line.split("\\s+")[3]);
                int secondElementColum = Integer.parseInt(line.split("\\s+")[4]);

                if (!(firstElementRow > numberOfRows - 1
                        || firstElementColum > numberOfColums - 1
                        || secondElementRow > numberOfRows - 1
                        || secondElementColum > numberOfColums - 1)) {
                    String firstElement = matrix[firstElementRow][firstElementColum];
                    String secondElement = matrix[secondElementRow][secondElementColum];

                    String bufferElement = firstElement;
                    matrix[firstElementRow][firstElementColum] = secondElement;
                    matrix[secondElementRow][secondElementColum] = bufferElement;

                    prinitMatrix(matrix);

                } else {
                    System.out.println("Invalid input!");
                }
            }


        }
    }

    private static void prinitMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int colum = 0; colum < matrix[row].length; colum++) {
                System.out.print(matrix[row][colum] + " ");
            }
            System.out.println();
        }
    }
}
