package L12_Exam.P2_Bomb;

import java.util.Scanner;

public class Main_2 {

    private static int playerPossitionRow;
    private static int playerPossitionColum;
    private static long bombCount;

    private static boolean iswin;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];

        playerPossitionRow = -1;
        playerPossitionColum = -1;

        bombCount = 0;

        for (int row = 0; row < sizeOfMatrix; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int colum = 0; colum < sizeOfMatrix; colum++) {
                String currentElement = tokens[colum];
                matrix[row][colum] = currentElement;

                if ("s".equals(currentElement)) {
                    playerPossitionRow = row;
                    playerPossitionColum = colum;
                }
                if ("B".equals(currentElement)) {
                    bombCount++;
                }

            }
        }

        iswin = false;
        for (int command = 0; command < commands.length; command++) {
            String currentCommand = commands[command];

            if (currentCommand.equals("left")) {
                if (entireMoveAndCheck(matrix, playerPossitionRow, playerPossitionColum - 1)) break;
            } else if (currentCommand.equals("right")) {
                if (entireMoveAndCheck(matrix, playerPossitionRow, playerPossitionColum + 1)) break;
            } else if(currentCommand.equals("up")) {
                if (entireMoveAndCheck(matrix, playerPossitionRow - 1, playerPossitionColum)) break;
            } else if (currentCommand.equals("down")) {
                if (entireMoveAndCheck(matrix, playerPossitionRow + 1, playerPossitionColum)) break;
            }
        }

        if (!iswin) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)" ,bombCount ,playerPossitionRow ,playerPossitionColum);
        }

    }

    private static boolean entireMoveAndCheck(String[][] matrix, int playerPossitionRow, int i) {
        if (!isOutOfBounds(playerPossitionRow, i, matrix)) {
            move(playerPossitionRow, i, matrix);
        }
        if (bombCount == 0) {
            System.out.println("Congratulations! You found all bombs!");
            iswin = true;
        }
        if (iswin) {
            return true;
        }
        return false;
    }

    public static void move(int row, int colum, String[][] matrix) {
        matrix[playerPossitionRow][playerPossitionColum] = "+";
        playerPossitionRow = row;
        playerPossitionColum = colum;
        if (matrix[playerPossitionRow][playerPossitionColum].equals("B")) {
            bombCount--;
            System.out.println("You found a bomb!");
        } else if (matrix[playerPossitionRow][playerPossitionColum].equals("e")) {
            iswin = true;
            System.out.printf("END! %d bombs left on the field" ,bombCount);
        }
        matrix[playerPossitionRow][playerPossitionColum] = "s";

    }

    private static boolean isOutOfBounds(int row, int col, String[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
