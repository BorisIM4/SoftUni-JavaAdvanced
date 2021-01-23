package L2_Multidimentional_Arrays_exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P6_String_Matrix_Rotation_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Take first line from console and take rotation value.
        String rotationOrder = scanner.nextLine();
        String rotationValueAsString = rotationOrder.substring(7 ,rotationOrder.length() - 1);
        int valueRotation = Integer.parseInt(rotationValueAsString);

        //Fill the List with input data
        List<String> listInputData = new LinkedList<>();
        String line = "";
        while (!"END".equals(line = scanner.nextLine())){
            listInputData.add(line);
        }

        //Check what is dimmensions of a matrix -> maxLenght of an element is is matrix number of colums
        int maxLenght = Integer.MIN_VALUE;
        for (int elementInList = 0; elementInList < listInputData.size(); elementInList++) {
            String currentElemet = listInputData.get(elementInList);
            int currentElementLenght = currentElemet.length();

            if (currentElementLenght > maxLenght) {
                maxLenght = currentElementLenght;
            }
        }

        //Create matrix and fill it with whitespaces
        char[][] initialMatrix = new char[listInputData.size()][maxLenght];
        for (int row = 0; row < listInputData.size(); row++) {
            for (int colum = 0; colum < maxLenght; colum++) {
                initialMatrix[row][colum] = ' ';
            }
        }

        //Fill matrix with listInputData
        for (int row = 0; row < listInputData.size(); row++) {
            for (int colum = 0; colum < listInputData.get(row).length(); colum++) {
                char symbol = listInputData.get(row).charAt(colum);

                initialMatrix[row][colum] = symbol;
            }
        }

        if (valueRotation == 90|| valueRotation % 360 == 90) {
            printMatrix90Degrees(initialMatrix ,maxLenght);
        } else if (valueRotation == 180 || valueRotation % 360 ==180) {
            printMatrix180Degrees(initialMatrix, maxLenght);
        } else if (valueRotation == 270 || valueRotation % 360 == 270) {
            printmatrix270Degrees(initialMatrix, maxLenght);
        } else if (valueRotation == 0 || valueRotation % 360 == 0) {
            printEveryMatrix(initialMatrix.length, maxLenght, initialMatrix);
        }

    }

    private static void printmatrix270Degrees(char[][] initialMatrix, int maxLenght) {
        int printmatrixRows = maxLenght;
        int printMatrixColums = initialMatrix.length;

        char[][] printMatrix = new char[printmatrixRows][printMatrixColums];

        int startRowOfinitialMatrix = printmatrixRows - 1;
        for (int row = 0; row < printmatrixRows; row++) {
            for (int colum = 0; colum < printMatrixColums; colum++) {
                printMatrix[row][colum] = initialMatrix[colum][startRowOfinitialMatrix];
            }
            startRowOfinitialMatrix--;
        }
        printEveryMatrix(printmatrixRows, printMatrixColums, printMatrix);
    }

    private static void printMatrix180Degrees(char[][] initialMatrix, int maxLenght) {
        int printedMatrixRow = initialMatrix.length;
        int printedMatrixColum = maxLenght;

        char[][] printMatrix = new char[printedMatrixRow][printedMatrixColum];

        int startRowInitialMatrix = printedMatrixRow - 1;
        for (int row = 0; row < printedMatrixRow; row++) {
            int startColumInitialMatrix = printedMatrixColum - 1;
            for (int colum = 0; colum < printedMatrixColum; colum++) {
                printMatrix[row][colum] = initialMatrix[startRowInitialMatrix][startColumInitialMatrix--];
            }
            startRowInitialMatrix--;
        }
        printEveryMatrix(printedMatrixRow, printedMatrixColum, printMatrix);
    }

    private static void printMatrix90Degrees(char[][] initialMatrix, int maxLenght) {
        int rowNumber = maxLenght;
        int columNumber = initialMatrix.length;
        char[][] printMatrix = new char[rowNumber][columNumber];
        for (int row = 0; row < rowNumber; row++) {
            int startnumebrForrRowInFirstM =columNumber - 1;
            for (int colum = 0; colum < columNumber; colum++) {
                printMatrix[row][colum] = initialMatrix[startnumebrForrRowInFirstM--][row];
            }
        }
        printEveryMatrix(rowNumber, columNumber, printMatrix);

    }

    private static void printEveryMatrix(int rowNumber, int columNumber, char[][] printMatrix) {
        for (int row = 0; row < rowNumber; row++) {
            for (int colum = 0; colum < columNumber; colum++) {
                System.out.print(printMatrix[row][colum]);
            }
            System.out.println();
        }
    }
}