package L1_Stacks_and_Queues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P9_Infix_to_Postfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine ().split ("\\s+");

        ArrayDeque<String> queueOfElements = new ArrayDeque<> ();
        ArrayDeque<String> stackOfOperators = new ArrayDeque<> ();

        List<String> listOfOperators = List.of ("+", "-", "/", "*");

        for (int i = 0; i < tokens.length; i++) {
            String currant = tokens[i];
            if (!listOfOperators.contains (currant)) {
                if (currant.equals (")")) {
                    String poppedElement = stackOfOperators.pop ();
                    while (!stackOfOperators.isEmpty ()) {
                        if (!poppedElement.equals ("(")) {
                            queueOfElements.offer (poppedElement);
                            poppedElement = stackOfOperators.pop ();
                        } else break;
                    }
                } else if (currant.equals ("(")){
                    stackOfOperators.push (currant);

                }else {
                    queueOfElements.offer (currant);
                }
            } else {
                while (!stackOfOperators.isEmpty ()) {
                    String lastElement = stackOfOperators.peek ();
                    if (listOfOperators.indexOf (lastElement) >= listOfOperators.indexOf (currant)) {
                        queueOfElements.offer (stackOfOperators.pop ());
                    }else break;
                }

                stackOfOperators.push (currant);

            }

        }
        while (!stackOfOperators.isEmpty ()) {
            queueOfElements.offer (stackOfOperators.pop ());
        }
        while (!queueOfElements.isEmpty ()) {
            System.out.print (queueOfElements.poll () + " ");
        }

    }
}
