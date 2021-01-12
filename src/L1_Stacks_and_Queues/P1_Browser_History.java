package L1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1_Browser_History {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stackOfBrowserUrls = new ArrayDeque<>();

        while (!input.equals("Home")){

            if (input.equals("back")){
                if (stackOfBrowserUrls.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stackOfBrowserUrls.pop();
                    System.out.println(stackOfBrowserUrls.peek());
                }
            } else {
                String url = input;
                stackOfBrowserUrls.push(url);
                System.out.println(url);
            }

            input = scanner.nextLine();
        }

    }
}
