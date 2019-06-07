package L2_Multidimentional_Arrays_exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class P6_String_Matrix_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //PHASE 1 - FIND ROTATION
        String command = scanner.nextLine();
        String rotationAsString = command.substring(7,command.length() - 1);
        int rotation = Integer.parseInt(rotationAsString);


        //PHASE 2 - FILING MATRIX
        //Create List for words from input
        ArrayList<String> wordHolder = new ArrayList<>();

        //fill List with all words from input
        String inputWords = scanner.nextLine();
        while (!inputWords.equals("END")){
            wordHolder.add(inputWords);
            inputWords = scanner.nextLine();
        }

        //check the longest word from the List
        int biggestSumOfChars = 0;
        int currentBiggestSumOfChars = 0;
        for (int words = 0; words < wordHolder.size(); words++) {
            String currentWord = wordHolder.get(words);
            for (int numberOfChars = 0; numberOfChars < currentWord.length(); numberOfChars++) {
                currentBiggestSumOfChars += 1;
            }
            if (currentBiggestSumOfChars > biggestSumOfChars){
                biggestSumOfChars = currentBiggestSumOfChars;
                currentBiggestSumOfChars = 0;
            }

        }

        //Create matrix
        int numberOfRows = wordHolder.size();
        int numberOfColums = biggestSumOfChars;
        char[][] matrix = new char[numberOfRows][numberOfColums];

        //Fill matrix with white spaces
        for (int rows = 0; rows < numberOfRows; rows++) {
            for (int colums = 0; colums < numberOfColums; colums++) {
                matrix[rows][colums] = ' ';
            }
        }

        //Fill matrix with chars from input
        for (int rows = 0; rows < wordHolder.size(); rows++) {
            String currentWord = wordHolder.get(rows);
            int currenetWordLenght = currentWord.length();
            for (int colums = 0; colums < currenetWordLenght; colums++) {
                char currentChar = currentWord.charAt(colums);
                matrix[rows][colums] = currentChar;

            }
        }

        System.out.println();

        //PHASE 3 - PRINT ROTATED MATRIX
        if(rotation == 0 || rotation % 360 == 0 ) {
            printMatrix(matrix);


        }else if(rotation == 90 || rotation % 360 == 90){
            int currentRow = numberOfColums;
            int currentColums = numberOfRows;
            char[][] rotatedMatrix90 = new char[currentRow][currentColums];

            int startRow = numberOfRows - 1;
            for (int colums = 0; colums < currentColums; colums++) {

                for (int rows = 0; rows < currentRow  ; rows++) {
                    rotatedMatrix90[rows][colums] = matrix[startRow][rows];
                }
                startRow--;
            }
            printMatrix(rotatedMatrix90);


        }else if (rotation == 180 || rotation % 360 == 180){
            int currentRow = numberOfRows;
            int currentColums = numberOfColums;
            char[][] rotatedMatrix180 = new char[currentRow][currentColums];

            int startRow = currentRow - 1;
            int startCol = currentColums - 1;
            for (int rows = 0; rows < currentRow; rows++) {
                for (int colums = 0; colums < currentColums; colums++) {
                    rotatedMatrix180[rows][colums] = matrix[startRow][startCol];
                    startCol--;
                }
                startCol = currentColums - 1;
                startRow--;
            }
            printMatrix(rotatedMatrix180);


        }else {
            int currentRow = numberOfColums;
            int currentColums = numberOfRows;
            char[][] rotatedMatrix270 = new char[currentRow][currentColums];

            int startIndexRow = currentRow - 1;
            for (int rows = 0; rows < currentRow; rows++) {
                for (int colums = 0; colums < currentColums; colums++) {
                    rotatedMatrix270[rows][colums] = matrix[colums][startIndexRow];

                }
                startIndexRow--;
            }
            printMatrix(rotatedMatrix270);

        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int colums = 0; colums < matrix[rows].length; colums++) {
                System.out.print(matrix[rows][colums]);
            }
            System.out.println();
        }
    }
}