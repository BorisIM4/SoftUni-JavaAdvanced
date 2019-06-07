package L2_Multidimentional_Arrays_exercise;

import java.util.Scanner;

public class P3_Diagonal_Difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int colum = 0; colum < line.length; colum++) {
                matrix[row][colum] = Integer.parseInt(line[colum]);
            }
        }

        sumPrimeDiagonal(matrix);
        sumSecondDiagonal(matrix);

        printDiagonalDifference(sumPrimeDiagonal(matrix), sumSecondDiagonal(matrix));

    }

    private static void printDiagonalDifference(int sumPrimeDiagonal, int sumSecondDiagonal) {
        int diagonalDifference = sumPrimeDiagonal - sumSecondDiagonal;

        int absDifference = Math.abs(diagonalDifference);

        System.out.println(absDifference);
    }

    private static int sumSecondDiagonal(int[][] matrix) {
        int sum = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int colums = 0; colums < matrix.length; colums++) {
                int flag = matrix.length - 1 - rows;

                if (colums == flag){
                        sum += matrix[rows][colums];
                }
            }
        }

        return sum;
    }

    private static int sumPrimeDiagonal(int[][] matrix) {
        int sum = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int colums = 0; colums < matrix.length; colums++) {
                if (rows == colums){
                    sum += matrix[rows][colums];
                }
            }
        }

        return sum;
    }
}
