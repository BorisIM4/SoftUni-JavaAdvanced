package L3_Sets_and_Maps_Advanced_exercise;

import java.util.*;

public class P5_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String line = "";
        while (!"search".equals(line = scanner.nextLine())) {
            String name = line.split("-")[0];
            String phoneNumber = line.split("-")[1];

            phonebook.putIfAbsent(name, phoneNumber);
            phonebook.put(name, phoneNumber);

        }

        while (!"stop".equals(line = scanner.nextLine())) {
            if (phonebook.containsKey(line)) {
                System.out.println(String.format("%s -> %s"
                ,line
                ,phonebook.get(line)));
            } else {
                System.out.println(String.format("Contact %s does not exist."
                ,line));
            }
        }
    }
}
