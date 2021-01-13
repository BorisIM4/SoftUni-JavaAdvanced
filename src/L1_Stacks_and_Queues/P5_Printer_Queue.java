package L1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P5_Printer_Queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> queueOfPrinters = new ArrayDeque<>();

        while (!input.equals("print")){
            if (!input.equals("cancel")){
                queueOfPrinters.offer(input);
            } else {
                if (queueOfPrinters.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    String pollElement = queueOfPrinters.poll();
                    System.out.printf("Canceled %s%n" ,pollElement);
                }
            }

            input = scanner.nextLine();
        }

        for (String element : queueOfPrinters) {
            System.out.println(element);
        }
    }
}
