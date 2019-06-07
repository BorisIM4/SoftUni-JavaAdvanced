package L2_Multidimentional_Arrays_exercise;

import java.util.Scanner;

public class P1_Fill_the_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int dimensionOfMatrix = Integer.parseInt(input.split(", ")[0]);
        String typeOfFillingMethod = input.split(", ")[1];


        int[][] matrix = new int[dimensionOfMatrix][dimensionOfMatrix];

        if (typeOfFillingMethod.equals("A")) {
            for (int row = 0; row < dimensionOfMatrix; row++) {
                int curretntElement = row + 1;
                for (int colums = 0; colums < dimensionOfMatrix; colums++) {
                    matrix[row][colums] = curretntElement;
                    curretntElement += dimensionOfMatrix;
                }
            }
        } else {
            int currentElelemt = 1;
            for (int colums = 0; colums < dimensionOfMatrix; colums++) {
                if (colums % 2 == 0){
                    for (int rows = 0; rows < dimensionOfMatrix; rows++) {
                        matrix[rows][colums] = currentElelemt;
                        currentElelemt++;
                    }
                } else {
                    for (int rows = dimensionOfMatrix - 1; rows >= 0; rows--) {
                        matrix[rows][colums] = currentElelemt;
                        currentElelemt++;
                    }
                }
            }
        }

        //printirane na matricata
        for (int i = 0; i < dimensionOfMatrix; i++) {
            for (int j = 0; j < dimensionOfMatrix; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
