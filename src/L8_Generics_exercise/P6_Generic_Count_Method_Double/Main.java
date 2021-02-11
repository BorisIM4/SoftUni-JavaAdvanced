package L8_Generics_exercise.P6_Generic_Count_Method_Double;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
            Double value = Double.parseDouble(scanner.nextLine());
            box.addValue(value);
        }

        Double toCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreaterElements(toCompare));
    }
}
