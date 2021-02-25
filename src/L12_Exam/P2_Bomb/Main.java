package L12_Exam.P2_Bomb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];

        int playerPossitionRow = -1;
        int playerPossitionColum = -1;

        long bombCount = 0;

        int endGameRow = -1;
        int endGameColum = -1;

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
                if ("e".equals(currentElement)){
                    endGameRow = row;
                    endGameColum = colum;
                }

            }
        }

        boolean flag = false;
        for (int command = 0; command < commands.length; command++) {

            String currentComamnd = commands[command];

            if ("left".equals(currentComamnd)) {
                //move left
                if (!isOutOfBounds(playerPossitionRow, playerPossitionColum - 1, matrix)) {
                    matrix[playerPossitionRow][playerPossitionColum] = "+";
                    playerPossitionColum -= 1;
                    if (matrix[playerPossitionRow][playerPossitionColum].equals("B")) {
                        bombCount--;
                        System.out.println("You found a bomb!");
                    } else if (matrix[playerPossitionRow][playerPossitionColum].equals("e")) {
                        System.out.printf("END! %d bombs left on the field" ,bombCount);
                        flag = true;
                        break;
                    }
                    if (bombCount == 0) {
                        System.out.println("Congratulations! You found all bombs!");
                        flag = true;
                        break;
                    }
                    matrix[playerPossitionRow][playerPossitionColum] = "s";
                }

            } else if ("right".equals(currentComamnd)) {
                if (!isOutOfBounds(playerPossitionRow, playerPossitionColum + 1, matrix)) {
                    matrix[playerPossitionRow][playerPossitionColum] = "+";
                    playerPossitionColum += 1;
                    if (matrix[playerPossitionRow][playerPossitionColum].equals("B")) {
                        bombCount--;
                        System.out.println("You found a bomb!");
                    } else if (matrix[playerPossitionRow][playerPossitionColum].equals("e")) {
                        System.out.printf("END! %d bombs left on the field" ,bombCount);
                        flag = true;
                        break;
                    }
                    if (bombCount == 0) {
                        System.out.println("Congratulations! You found all bombs!");
                        flag = true;
                        break;
                    }
                    matrix[playerPossitionRow][playerPossitionColum] = "s";
                }
            } else if ("up".equals(currentComamnd)) {
                if (!isOutOfBounds(playerPossitionRow - 1, playerPossitionColum, matrix)) {
                    matrix[playerPossitionRow][playerPossitionColum] = "+";
                    playerPossitionRow -= 1;
                    if (matrix[playerPossitionRow][playerPossitionColum].equals("B")) {
                        bombCount--;
                        System.out.println("You found a bomb!");
                    } else if (matrix[playerPossitionRow][playerPossitionColum].equals("e")) {
                        System.out.printf("END! %d bombs left on the field" ,bombCount);
                        flag = true;
                        break;
                    }
                    if (bombCount == 0) {
                        System.out.println("Congratulations! You found all bombs!");
                        flag = true;
                        break;
                    }
                    matrix[playerPossitionRow][playerPossitionColum] = "s";
                }
            } else if ("down".equals(currentComamnd)) {
                if (!isOutOfBounds(playerPossitionRow + 1, playerPossitionColum, matrix)) {
                    matrix[playerPossitionRow][playerPossitionColum] = "+";
                    playerPossitionRow += 1;
                    if (matrix[playerPossitionRow][playerPossitionColum].equals("B")) {
                        bombCount--;
                        System.out.println("You found a bomb!");
                    } else if (matrix[playerPossitionRow][playerPossitionColum].equals("e")) {
                        System.out.printf("END! %d bombs left on the field" ,bombCount);
                        flag = true;
                        break;
                    }
                    if (bombCount == 0) {
                        System.out.println("Congratulations! You found all bombs!");
                        flag = true;
                        break;
                    }
                    matrix[playerPossitionRow][playerPossitionColum] = "s";
                }

            }

        }

        if (!flag) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)" ,bombCount ,playerPossitionRow ,playerPossitionColum);
        }

    }

//    private static long ifBombWasFound(String[][] matrix, int playerPossitionRow, int playerPossitionColum, long bombCount) {
//        if (matrix[playerPossitionRow][playerPossitionColum].equals("B")) {
//            bombCount--;
//            System.out.println("You found a bomb!");
//        }
//        return bombCount;
//    }

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
