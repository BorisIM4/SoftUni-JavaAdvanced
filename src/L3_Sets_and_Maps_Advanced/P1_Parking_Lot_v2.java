package L3_Sets_and_Maps_Advanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P1_Parking_Lot_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> carNumbers = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String carNumber = tokens[1];

            if ("IN".equals(command)) {
                carNumbers.add(carNumber);
            } else if ("OUT".equals(command)) {
                carNumbers.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : carNumbers) {
                System.out.println(carNumber);
            }
        }
    }
}
