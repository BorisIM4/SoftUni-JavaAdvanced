package L9_Iterators_and_Comparators_exercise.P3_Stack_Iterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack customStack = new CustomStack();
        String[] initialValues = scanner.nextLine().split(",\\s+");

        customStack.push(Integer.parseInt(initialValues[0].split("\\s+")[1]));

        for (int i = 1; i < initialValues.length; i++) {
            customStack.push(Integer.parseInt(initialValues[i].trim()));
        }

        String line = "";
        while (!"END".equals(line = scanner.nextLine())) {
            if (line.equals("Pop")) {
                //pop
                try {
                    customStack.pop();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                //push
                customStack.push(Integer.parseInt(line.split("\\s+")[1]));
            }
        }

        for (int i = 0; i < 2; i++) {
            for (Integer elements: customStack) {
                System.out.println(elements);
            }
        }
    }
}
