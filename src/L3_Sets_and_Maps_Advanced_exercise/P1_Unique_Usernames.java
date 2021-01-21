package L3_Sets_and_Maps_Advanced_exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P1_Unique_Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());

        Set<String> names = new LinkedHashSet<>();

        for (int name = 0; name < numberOfInputs; name++) {
            String currentName = scanner.nextLine();
            names.add(currentName);
        }
        names.forEach(System.out::println);
    }
}
