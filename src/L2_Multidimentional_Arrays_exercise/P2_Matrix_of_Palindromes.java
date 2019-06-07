package L2_Multidimentional_Arrays_exercise;

import java.util.Scanner;

public class P2_Matrix_of_Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int numberOfRows = Integer.parseInt(input.split("\\s+")[0]);
        int numberOfcolums = Integer.parseInt(input.split("\\s+")[1]);

        int numberOfRowsForLoop = numberOfRows + 97;
        int numberOfColumsForLoop = numberOfcolums + 97;

        String[][] matrix = new String[numberOfRows][numberOfcolums];
        String currentElement = "";

        for (char rows = 'a'; rows < numberOfRowsForLoop; rows++) {
            for (char colums = rows; colums < numberOfColumsForLoop; colums++) {
                char firstChar = rows;
                char secondChar = colums;
                char thirdChar = rows;

                currentElement += firstChar + "" + secondChar + "" + thirdChar + " ";
            }
            numberOfColumsForLoop++;
        }

        String[] currentElementAsArray = currentElement.split("\\s+");

        int helpNumber = 0;
        for (int rows = 0; rows < numberOfRows; rows++) {
            for (int colums = 0; colums < numberOfcolums; colums++) {
                matrix[rows][colums] = currentElementAsArray[colums + helpNumber];
            }
            helpNumber += numberOfcolums;
        }

        for (int rows = 0; rows < numberOfRows; rows++) {
            for (int colums = 0; colums < numberOfcolums; colums++) {
                System.out.print(matrix[rows][colums] + " ");
            }
            System.out.println();
        }
    }
}