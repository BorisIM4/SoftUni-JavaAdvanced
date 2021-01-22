package L3_Sets_and_Maps_Advanced_exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P7_Fix_Emails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> validEmails = new LinkedHashMap<>();

        String line = "";
        while (!"stop".equals(line = scanner.nextLine())) {
            String name = line;
            String email = scanner.nextLine();

            int startIndex = email.indexOf('.');
            String domain = email.substring(startIndex+1);

            if (!(domain.equals("uk") || domain.equals("us") || domain.equals("com"))) {
                validEmails.putIfAbsent(name, email);
                validEmails.put(name,email);
            }
        }
        validEmails.forEach((name, email) -> {
            System.out.println(String.format("%s -> %s"
            ,name
            ,email));
        });
    }
}
