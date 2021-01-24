package L2_Multidimentional_Arrays_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P4_Maximal_Sum_v4 {

    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensionsOfMatrix = scanner.nextLine().split("\\s+");
        int numberOfRows = Integer.parseInt(dimensionsOfMatrix[0]);
        int numberOfColums = Integer.parseInt(dimensionsOfMatrix[1]);

        int[][] matrix = new int[numberOfRows][numberOfColums];

        for (int row = 0; row < numberOfRows; row++) {
            int[] elementsInRow = Arrays
                    .stream(scanner
                            .nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int colum = 0; colum < numberOfColums; colum++) {
                int currentElement = elementsInRow[colum];
                matrix[row][colum] = currentElement;
            }
        }

        List<int[]> allSums = new ArrayList<>();
        int numberOfRowsForSum = numberOfRows - 2;
        int numberOfColumForSum = numberOfColums - 2;
        for (int row = 0; row < numberOfRowsForSum; row++) {
            for (int colum = 0; colum < numberOfColumForSum; colum++) {

                int currnetSum = matrix[row][colum] + matrix[row][colum + 1] + matrix[row][colum + 2]
                        + matrix[row + 1][colum] + matrix[row + 1][colum + 1] + matrix[row + 1][colum + 2]
                        + matrix[row + 2][colum] + matrix[row + 2][colum + 1] + matrix[row + 2][colum + 2];

                int[] currentArray = new int[3];
                currentArray[0] = currnetSum;
                currentArray[1] = row;
                currentArray[2] = colum;

                allSums.add(currentArray);
            }
        }

        int maxValueSum = Integer.MIN_VALUE;
        int maxValueRow = Integer.MIN_VALUE;
        int maxValueColum = Integer.MIN_VALUE;

        for (int[] element : allSums) {
            int currnetElementSum = element[0];
            int currnetRow = element[1];
            int currnetColum = element[2];
            if (currnetElementSum > maxValueSum) {
                maxValueSum = currnetElementSum;
                maxValueRow = currnetRow;
                maxValueColum = currnetColum;
            }
        }

        System.out.println(String.format("Sum = %d", maxValueSum));
        for (int row = maxValueRow; row <= maxValueRow + 2; row++) {
            for (int colum = maxValueColum; colum <= maxValueColum + 2; colum++) {
                System.out.print(String.format("%d ", matrix[row][colum]));
            }
            System.out.println();
        }

    }
}
