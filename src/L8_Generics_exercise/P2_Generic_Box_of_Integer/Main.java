package L8_Generics_exercise.P2_Generic_Box_of_Integer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfinputs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfinputs; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(element);
            System.out.println(box.toString());
        }
    }
}
