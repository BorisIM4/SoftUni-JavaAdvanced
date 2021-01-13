package L1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class P6_Hot_Potato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] namesAsString = input.split("\\s+");
        List<String> listOfchildren = Arrays.asList(namesAsString);

        ArrayDeque<String> queueOfChildren = new ArrayDeque<>(listOfchildren);

        int numberOfCicles = Integer.parseInt(scanner.nextLine());

        while (queueOfChildren.size() > 1){
            for (int i = 0; i < numberOfCicles; i++) {
                if (i == numberOfCicles - 1){
                    String nameOflostPPL = queueOfChildren.poll();
                    System.out.printf("Removed %s%n" ,nameOflostPPL);
                    break;
                }
                String name = queueOfChildren.poll();
                queueOfChildren.offer(name);
            }

        }

        System.out.printf("Last is %s" ,queueOfChildren.peek());

    }
}
