package L2_Multidimentional_Arrays_exercise;

import java.util.Scanner;

public class P5_Matrix_shuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRows = scanner.nextInt();
        int numberOfColums = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[numberOfRows][numberOfColums];

        for (int rows = 0; rows < numberOfRows; rows++) {
            matrix[rows] = scanner.nextLine().split("\\s+");
        }


        String[] commandLines = scanner.nextLine().split("\\s+");

        while (!commandLines[0].equals("END")){
            String command = commandLines[0];

            if (!command.equals("swap") || commandLines.length > 5){
                System.out.println("Invalid input!");
            }else {
                int firstRowIndex = Integer.parseInt(commandLines[1]);
                int firstColIndex = Integer.parseInt(commandLines[2]);
                int secondRowIndex = Integer.parseInt(commandLines[3]);
                int secondColIndex = Integer.parseInt(commandLines[4]);

                if (firstRowIndex > numberOfRows
                        || firstColIndex > numberOfColums
                        || secondRowIndex > numberOfRows
                        || secondColIndex > numberOfColums){
                    System.out.println("Invalid input!");
                } else {
                    String currendtFirstElement = matrix[firstRowIndex][firstColIndex];
                    String currentSecondElement = matrix[secondRowIndex][secondColIndex];

                    matrix[firstRowIndex][firstColIndex] = currentSecondElement;
                    matrix[secondRowIndex][secondColIndex] = currendtFirstElement;

                    printMatrix(matrix);
                }
            }
            commandLines = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int colums = 0; colums < matrix[rows].length; colums++) {
                System.out.print(matrix[rows][colums] + " ");
            }
            System.out.println();
        }
    }
}
