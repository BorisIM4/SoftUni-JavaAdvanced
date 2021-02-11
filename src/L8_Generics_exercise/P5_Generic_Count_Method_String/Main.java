package L8_Generics_exercise.P5_Generic_Count_Method_String;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

       Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String value = scanner.nextLine();
            box.addValue(value);
        }

        String toCompare = scanner.nextLine();
        System.out.println(box.countGreaterElements(toCompare));
    }
}