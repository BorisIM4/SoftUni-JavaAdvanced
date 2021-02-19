package L10_Exam_Preparation_Two.Exam_2020_02_22.P2_ReVolt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfMatrix = Integer.parseInt(scanner.nextLine());
        int numberOfComands = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[sizeOfMatrix][sizeOfMatrix];
        int playerPossitionRow = -1;
        int playerPossitionColum = -1;
        for (int row = 0; row < sizeOfMatrix; row++) {
            String[] tokens = scanner.nextLine().split("");
            for (int colum = 0; colum < sizeOfMatrix; colum++) {
                String currnetElement= tokens[colum];
                matrix[row][colum] = currnetElement;
                if ("f".equals(currnetElement)) {
                    playerPossitionRow = row;
                    playerPossitionColum = colum;
                }
            }
        }
        String line = "";
        boolean isWin = false;
        while (numberOfComands-- > 0) {
            line = scanner.nextLine();
            if ("up".equals(line)) {
                if (!isOutOfBounds(playerPossitionRow - 1, playerPossitionColum, matrix)){
                    if ("-".equals(matrix[playerPossitionRow - 1][playerPossitionColum])) {
                        playerPossitionRow = movePlayerUp(matrix, playerPossitionRow, playerPossitionColum);
                    } else if ("F".equals(matrix[playerPossitionRow - 1][playerPossitionColum])) {
                        playerPossitionRow = movePlayerUp(matrix, playerPossitionRow, playerPossitionColum);
                        isWin = true;
                    } else if ("B".equals(matrix[playerPossitionRow - 1][playerPossitionColum])) {
                        if (!isOutOfBounds(playerPossitionRow - 2, playerPossitionColum, matrix)) {
                            matrix[playerPossitionRow][playerPossitionColum] = "-";
                            playerPossitionRow -= 2;
                            isWin = possitionWin(matrix, playerPossitionRow, playerPossitionColum, isWin);
                            matrix[playerPossitionRow][playerPossitionColum] = "f";
                        } else {
                            matrix[playerPossitionRow][playerPossitionColum] = "-";
                            playerPossitionRow = sizeOfMatrix - 1;
                            isWin = possitionWin(matrix, playerPossitionRow, playerPossitionColum, isWin);
                            matrix[playerPossitionRow][playerPossitionColum] = "f";
                        }
                    }
                } else {
                    if ("-".equals(matrix[sizeOfMatrix - 1][playerPossitionColum])) {
                        playerPossitionRow = movePlayerUpOutBounds(sizeOfMatrix, matrix, playerPossitionRow, playerPossitionColum, 1);
                    } else if ("F".equals(matrix[sizeOfMatrix - 1][playerPossitionColum])) {
                        playerPossitionRow = movePlayerUpOutBounds(sizeOfMatrix, matrix, playerPossitionRow, playerPossitionColum, 1);
                        isWin = true;
                    } else if ("B".equals(matrix[sizeOfMatrix - 1][playerPossitionColum])) {
                        if ("-".equals(matrix[sizeOfMatrix - 2][playerPossitionColum])) {
                            playerPossitionRow = movePlayerUpOutBounds(sizeOfMatrix, matrix, playerPossitionRow, playerPossitionColum, 2);
                        } else if ("F".equals(matrix[playerPossitionRow - 2][playerPossitionColum])) {
                            playerPossitionRow = movePlayerUpOutBounds(sizeOfMatrix, matrix, playerPossitionRow, playerPossitionColum, 2);
                            isWin = true;
                        }
                    }
                }
                if (ifWinPrint(isWin)) break;
            } else if ("down".equals(line)) {
                if (!isOutOfBounds(playerPossitionRow + 1, playerPossitionColum, matrix)){
                    if ("-".equals(matrix[playerPossitionRow + 1][playerPossitionColum])) {
                        playerPossitionRow = movePlayerDown(matrix, playerPossitionRow, playerPossitionColum);
                    } else if ("F".equals(matrix[playerPossitionRow + 1][playerPossitionColum])) {
                        playerPossitionRow = movePlayerDown(matrix, playerPossitionRow, playerPossitionColum);
                        isWin = true;
                    } else if ("B".equals(matrix[playerPossitionRow + 1][playerPossitionColum])) {
                        if (!isOutOfBounds(playerPossitionRow + 2, playerPossitionColum, matrix)) {
                            matrix[playerPossitionRow][playerPossitionColum] = "-";
                            playerPossitionRow += 2;
                            isWin = possitionWin(matrix, playerPossitionRow, playerPossitionColum, isWin);
                            matrix[playerPossitionRow][playerPossitionColum] = "f";
                        } else {
                            matrix[playerPossitionRow][playerPossitionColum] = "-";
                            playerPossitionRow = 0;
                            isWin = possitionWin(matrix, playerPossitionRow, playerPossitionColum, isWin);
                            matrix[playerPossitionRow][playerPossitionColum] = "f";
                        }
                    }
                } else {
                    if ("-".equals(matrix[0][playerPossitionColum])) {
                        playerPossitionRow = movePlayerDownOutBounds(matrix, playerPossitionRow, playerPossitionColum, 0);
                    } else if ("F".equals(matrix[0][playerPossitionColum])) {
                        playerPossitionRow = movePlayerDownOutBounds(matrix, playerPossitionRow, playerPossitionColum, 0);
                        isWin = true;
                    } else if ("B".equals(matrix[0][playerPossitionColum])) { //proverqvam dali sledva]ata poziciq e bonus
                        if ("-".equals(matrix[1][playerPossitionColum])) {
                            playerPossitionRow = movePlayerDownOutBounds(matrix, playerPossitionRow, playerPossitionColum, 1);
                        } else if ("F".equals(matrix[1][playerPossitionColum])) {
                            playerPossitionRow = movePlayerDownOutBounds(matrix, playerPossitionRow, playerPossitionColum, 1);
                            isWin = true;
                        }
                    }
                }
                if (ifWinPrint(isWin)) break;
            } else if ("left".equals(line)) {
                if (!isOutOfBounds(playerPossitionRow, playerPossitionColum - 1, matrix)){
                    if ("-".equals(matrix[playerPossitionRow][playerPossitionColum - 1])) {
                        playerPossitionColum = movePlayerLeft(matrix, playerPossitionRow, playerPossitionColum);
                    } else if ("F".equals(matrix[playerPossitionRow][playerPossitionColum - 1])) {
                        playerPossitionColum = movePlayerLeft(matrix, playerPossitionRow, playerPossitionColum);
                        isWin = true;
                    } else if ("B".equals(matrix[playerPossitionRow][playerPossitionColum - 1])) { //proverqvam dali sledva]ata poziciq e bonus
                        if (!isOutOfBounds(playerPossitionRow, playerPossitionColum - 2, matrix)) {
                            matrix[playerPossitionRow][playerPossitionColum] = "-";
                            playerPossitionColum -= 2;
                            isWin = possitionWin(matrix, playerPossitionRow, playerPossitionColum, isWin);
                            matrix[playerPossitionRow][playerPossitionColum] = "f";
                        } else {
                            matrix[playerPossitionRow][playerPossitionColum] = "-";
                            playerPossitionColum = sizeOfMatrix - 1;
                            isWin = possitionWin(matrix, playerPossitionRow, playerPossitionColum, isWin);
                            matrix[playerPossitionRow][playerPossitionColum] = "f";
                        }
                    }
                } else {
                    if ("-".equals(matrix[playerPossitionRow][sizeOfMatrix - 1])) {
                        playerPossitionColum = movePlayerLeftOutDounds(sizeOfMatrix, matrix, playerPossitionRow, playerPossitionColum, 1);
                    } else if ("F".equals(matrix[playerPossitionRow][sizeOfMatrix - 1])) {
                        playerPossitionColum = movePlayerLeftOutDounds(sizeOfMatrix, matrix, playerPossitionRow, playerPossitionColum, 1);
                        isWin = true;
                    } else if ("B".equals(matrix[playerPossitionRow][sizeOfMatrix - 1])) {
                        if ("-".equals(matrix[playerPossitionRow][sizeOfMatrix - 2])) {
                            playerPossitionColum = movePlayerLeftOutDounds(sizeOfMatrix, matrix, playerPossitionRow, playerPossitionColum, 2);
                        } else if ("F".equals(matrix[playerPossitionRow][playerPossitionRow - 2])) {
                            playerPossitionColum = movePlayerLeftOutDounds(sizeOfMatrix, matrix, playerPossitionRow, playerPossitionColum, 2);
                            isWin = true;
                        }
                    }
                }
                if (ifWinPrint(isWin)) break;
            } else if ("right".equals(line)) {
                if (!isOutOfBounds(playerPossitionRow, playerPossitionColum + 1, matrix)){
                    if ("-".equals(matrix[playerPossitionRow][playerPossitionColum + 1])) {
                        playerPossitionColum = movePlayerRight(matrix, playerPossitionRow, playerPossitionColum);
                    } else if ("F".equals(matrix[playerPossitionRow][playerPossitionColum + 1])) {
                        playerPossitionColum = movePlayerRight(matrix, playerPossitionRow, playerPossitionColum);
                        isWin = true;
                    } else if ("B".equals(matrix[playerPossitionRow][playerPossitionColum + 1])) {
                        if (!isOutOfBounds(playerPossitionRow, playerPossitionColum + 2, matrix)) {
                            matrix[playerPossitionRow][playerPossitionColum] = "-";
                            playerPossitionColum += 2;
                            isWin = possitionWin(matrix, playerPossitionRow, playerPossitionColum, isWin);
                            matrix[playerPossitionRow][playerPossitionColum] = "f";
                        } else {
                            matrix[playerPossitionRow][playerPossitionColum] = "-";
                            playerPossitionColum = 0;
                            isWin = possitionWin(matrix, playerPossitionRow, playerPossitionColum, isWin);
                            matrix[playerPossitionRow][playerPossitionColum] = "f";
                        }
                    }
                } else {
                    if ("-".equals(matrix[playerPossitionRow][0])) {
                        playerPossitionColum = movePlayerRightOutBounds(matrix, playerPossitionRow, playerPossitionColum, 0);
                    } else if ("F".equals(matrix[playerPossitionRow][0])) {
                        playerPossitionColum = movePlayerRightOutBounds(matrix, playerPossitionRow, playerPossitionColum, 0);
                        isWin = true;
                    } else if ("B".equals(matrix[playerPossitionRow][0])) {
                        if ("-".equals(matrix[playerPossitionRow][1])) {
                            playerPossitionColum = movePlayerRightOutBounds(matrix, playerPossitionRow, playerPossitionColum, 1);
                        } else if ("F".equals(matrix[playerPossitionRow][1])) {
                            playerPossitionColum = movePlayerRightOutBounds(matrix, playerPossitionRow, playerPossitionColum, 1);
                            isWin = true;
                        }
                    }
                }
                if (ifWinPrint(isWin)) break;
            }
        }
        //Final print
        if (!isWin){
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static boolean ifWinPrint(boolean isWin) {
        if (isWin) {
            System.out.println("Player won!");
            return true;
        }
        return false;
    }

    private static int movePlayerRightOutBounds(String[][] matrix, int playerPossitionRow, int playerPossitionColum, int i) {
        matrix[playerPossitionRow][playerPossitionColum] = "-";
        playerPossitionColum = i;
        matrix[playerPossitionRow][playerPossitionColum] = "f";
        return playerPossitionColum;
    }

    private static int movePlayerLeftOutDounds(int sizeOfMatrix, String[][] matrix, int playerPossitionRow, int playerPossitionColum, int i) {
        playerPossitionColum = movePlayerRightOutBounds(matrix, playerPossitionRow, playerPossitionColum, sizeOfMatrix - i);
        return playerPossitionColum;
    }

    private static int movePlayerDownOutBounds(String[][] matrix, int playerPossitionRow, int playerPossitionColum, int i) {
        matrix[playerPossitionRow][playerPossitionColum] = "-";
        playerPossitionRow = i;
        matrix[playerPossitionRow][playerPossitionColum] = "f";
        return playerPossitionRow;
    }

    private static int movePlayerUpOutBounds(int sizeOfMatrix, String[][] matrix, int playerPossitionRow, int playerPossitionColum, int i) {
        playerPossitionRow = movePlayerDownOutBounds(matrix, playerPossitionRow, playerPossitionColum, sizeOfMatrix - i);
        return playerPossitionRow;
    }

    private static int movePlayerRight(String[][] matrix, int playerPossitionRow, int playerPossitionColum) {
        matrix[playerPossitionRow][playerPossitionColum] = "-";
        playerPossitionColum += 1;
        matrix[playerPossitionRow][playerPossitionColum] = "f";
        return playerPossitionColum;
    }

    private static int movePlayerLeft(String[][] matrix, int playerPossitionRow, int playerPossitionColum) {
        matrix[playerPossitionRow][playerPossitionColum] = "-";
        playerPossitionColum -= 1;
        matrix[playerPossitionRow][playerPossitionColum] = "f";
        return playerPossitionColum;
    }

    private static int movePlayerDown(String[][] matrix, int playerPossitionRow, int playerPossitionColum) {
        matrix[playerPossitionRow][playerPossitionColum] = "-";
        playerPossitionRow += 1;
        matrix[playerPossitionRow][playerPossitionColum] = "f";
        return playerPossitionRow;
    }

    private static boolean possitionWin(String[][] matrix, int playerPossitionRow, int playerPossitionColum, boolean isWin) {
        if ("F".equals(matrix[playerPossitionRow][playerPossitionColum])) {
            matrix[playerPossitionRow][playerPossitionColum] = "f";
            isWin = true;
        }
        return isWin;
    }

    private static int movePlayerUp(String[][] matrix, int playerPossitionRow, int playerPossitionColum) {
        matrix[playerPossitionRow][playerPossitionColum] = "-";
        playerPossitionRow -= 1;
        matrix[playerPossitionRow][playerPossitionColum] = "f";
        return playerPossitionRow;
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