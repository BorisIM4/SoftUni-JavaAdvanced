package L2_Multidimentional_Arrays_exercise;

import java.util.Scanner;

public class P1_Fill_the_Matrix_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int matrixDimencion = Integer.parseInt(input.split(", ")[0]);
        String typeOfFiling = input.split(", ")[1];

        int[][] matrix;

        if (typeOfFiling.equals("A")){
            matrix = generateMatrixWithTypeA(matrixDimencion);

        } else {
            matrix = generateMatrixWithTypeB(matrixDimencion);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int colums = 0; colums < matrix[rows].length; colums++) {
                System.out.print(matrix[rows][colums] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] generateMatrixWithTypeB(int matrixDimencion) {
        int[][] matrix = new int[matrixDimencion][matrixDimencion];

        int startElement = 1;
        for (int colums = 0; colums < matrixDimencion; colums++) {
            if (colums % 2 == 0){
                for (int rows = 0; rows < matrixDimencion; rows++) {
                    matrix[rows][colums] = startElement;
                    startElement++;

                }
            } else {
                for (int rows = matrixDimencion - 1; rows >= 0; rows--) {
                    matrix[rows][colums] = startElement;
                    startElement++;
                }
            }
        }

        return matrix;
    }

    private static int[][] generateMatrixWithTypeA(int matrixDimencion) {
        int[][] matrix = new int[matrixDimencion][matrixDimencion];

        int value = 1;
        for (int colums = 0; colums < matrixDimencion; colums++) {
            for (int rows = 0; rows < matrixDimencion; rows++) {
                matrix[rows][colums] = value;
                value++;
            }
        }

        return matrix;
    }
}
