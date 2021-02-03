package L1_Stacks_and_Queues_exercise;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class P8_Simple_Text_Editor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String[]> stackCommands = new ArrayDeque<>();
        ArrayDeque<String> stackOfDeletedElements = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            if (Integer.parseInt(token[0]) == 1) {
                String currentText = token[1];
                stackCommands.push(token);
                text.append(currentText);

            } else if (Integer.parseInt(token[0]) == 2) {
                int numberOfElementtoBeErased = Integer.parseInt(token[1]);
                int numberOfLastRotation = text.length() - numberOfElementtoBeErased;

                StringBuilder removedTextStringBuilder = new StringBuilder();
                for (int j = text.length() - 1; j >= numberOfLastRotation; j--) {
                    char currChar = text.charAt(j);
                    text.deleteCharAt(j);
                    removedTextStringBuilder.append(currChar);
                }
                String removedText = removedTextStringBuilder.reverse().toString();
                stackOfDeletedElements.push(removedText);

                stackCommands.push(token);

            } else if (Integer.parseInt(token[0]) == 3) {
                if (text.length() > 0) {
                    int possitionOfElementToBePrinted = Integer.parseInt(token[1]);
                    System.out.println(text.charAt(possitionOfElementToBePrinted - 1));
                }

            } else if (Integer.parseInt(token[0]) == 4) {
                String[] tokenPoped = stackCommands.pop();
                // Ako posldnata komanda e bila da se dobavi nesho, sega trqbvad da go premahenm.
                if (Integer.parseInt(tokenPoped[0]) == 1) {
                    String textToBeRemoved = tokenPoped[1];
                    int indexToBeRemoved = text.lastIndexOf(textToBeRemoved);
                    text.delete(indexToBeRemoved, text.length());
                }
                //Ako poslednata komanda e bila ne]o da se iztrie to sega go dobawqm kym teksta
                else if (Integer.parseInt(tokenPoped[0]) == 2) {
                    String elementToBeAddedToTheText = stackOfDeletedElements.pop();
                    text.append(elementToBeAddedToTheText);
                }
            }

        }
    }
}
