package L1_Stacks_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P8_Browser_History_Upgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stackOfBrowserUrls = new ArrayDeque<>();
        ArrayDeque<String> browserHistoryQueue = new ArrayDeque<>();

        while (!input.equals("Home")){
            if (!input.equals("back") && !input.equals("forward")){
                stackOfBrowserUrls.push(input);
                System.out.println(input);
                browserHistoryQueue.clear();

            } else if (input.equals("back")) {
                if (stackOfBrowserUrls.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    String urlToGoInForward = stackOfBrowserUrls.pop();
                    System.out.println(stackOfBrowserUrls.peek());
                    browserHistoryQueue.addFirst(urlToGoInForward);
                }

            } else {
                if (browserHistoryQueue.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String urlToGoToBack = browserHistoryQueue.poll();
                    System.out.println(urlToGoToBack);
                    stackOfBrowserUrls.push(urlToGoToBack);
                }

            }


            input = scanner.nextLine();
        }

    }
}
