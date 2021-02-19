package L10_Exam_Preparation_Two.Exam_2019_10_26.P1_Dating_App;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> maleStack = new ArrayDeque<>();
        Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(e -> e > 0)
                .forEach(maleStack::push);

        Deque<Integer> femalesQueue = Arrays
                .stream(scanner
                        .nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .filter(e -> e > 0)
                .collect(Collectors
                        .toCollection(ArrayDeque::new));

        int matchesCount = 0;
        while (!maleStack.isEmpty() && !femalesQueue.isEmpty()) {

            // Check is mlaes divisible to 25
            int stackSize = maleStack.size();
            for (int i = 0; i < stackSize; i++) {
                int currentElement = maleStack.pop();
                if (currentElement % 25 == 0) {
                    maleStack.pop();
                    stackSize--;
                } else {
                    maleStack.addLast(currentElement);
                }
            }

            //Check is femlaes divisible to 25
            int queueSize = femalesQueue.size();
            for (int i = 0; i < queueSize; i++) {
                int currentElement = femalesQueue.poll();
                if (currentElement % 25 == 0) {
                    femalesQueue.poll();
                    queueSize--;
                } else {
                    femalesQueue.addLast(currentElement);
                }
            }

            int currentMale = maleStack.pop();
            int currenetFemale = femalesQueue.poll();

            if (currentMale != currenetFemale) {
                maleStack.push(currentMale - 2);
                if (maleStack.peek() <= 0) {
                    maleStack.pop();
                }
            } else {
                matchesCount++;
            }
        }
        System.out.printf("Matches: %d%n" ,matchesCount);
        if (maleStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            String stringOfMales = maleStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.printf("Males left: %s%n", stringOfMales);
        }

        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String stringOfFemales = femalesQueue
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.printf("Females left: %s%n", stringOfFemales);
        }

    }
}