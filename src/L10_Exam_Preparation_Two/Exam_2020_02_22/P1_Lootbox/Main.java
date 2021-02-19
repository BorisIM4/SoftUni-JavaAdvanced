package L10_Exam_Preparation_Two.Exam_2020_02_22.P1_Lootbox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> firstLootBoxQueue = new ArrayDeque<>();
        Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstLootBoxQueue::offer);

        Deque<Integer> secondLootBoxStack = new ArrayDeque<>();
        Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondLootBoxStack::push);

        int valueOfItems = 0;

        while (!firstLootBoxQueue.isEmpty() && !secondLootBoxStack.isEmpty()) {
            int firstBoxCurrentElement = firstLootBoxQueue.peek();
            int secondBoxCurrentElement = secondLootBoxStack.peek();
            int sumOfElement = firstBoxCurrentElement + secondBoxCurrentElement;

            if (sumOfElement % 2 == 0) {
                firstLootBoxQueue.poll();
                secondLootBoxStack.pop();
                valueOfItems += sumOfElement;
            } else {
                //remove element from stack to put it in queue
                int removedElement = secondLootBoxStack.pop();
                firstLootBoxQueue.addLast(removedElement);

            }
        }

        if (firstLootBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (valueOfItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d" ,valueOfItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d" ,valueOfItems);
        }
    }
}
