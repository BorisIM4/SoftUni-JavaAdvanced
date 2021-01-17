package L2_Multidimensional_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P2_Positions_Of {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int colums = dimensions[1];

        int[][] matrix = new int[rows][colums];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int token = 0; token < tokens.length; token++) {
                int element = Integer.parseInt(tokens[token]);
                matrix[row][token] = element;
            }
        }

        int number = Integer.parseInt(scanner.nextLine());

        ArrayList<int []> possitions = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int colum = 0; colum < matrix[row].length; colum++) {
                if (matrix[row][colum] == number) {
                    int[] indexes = new int[]{row, colum};
                    possitions.add(indexes);
                }
            }
        }
        if (possitions.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] position:possitions) {
                System.out.println(position[0] + " " + position[1]);
            }
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndColums = readArray(scanner);
        int rows = rowsAndColums[0];
        int colums = rowsAndColums[1];

        int[][] matrix = new int[rows][colums];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner);
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int colum = 0; colum < matrix[row].length; colum++) {
                System.out.print(matrix[row][colum] + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
