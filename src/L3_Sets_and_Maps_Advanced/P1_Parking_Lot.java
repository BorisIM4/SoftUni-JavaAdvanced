package L3_Sets_and_Maps_Advanced;

import java.util.HashSet;
import java.util.Scanner;

public class P1_Parking_Lot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> carsRegistrationSet = new HashSet<>();

        String[] input = scanner.nextLine().split(", ");

        while (!input[0].equals("END")){
            String direction = input[0];
            String carRegistration = input[1];

            if (direction.equals("IN")){
                carsRegistrationSet.add(carRegistration);
            }
            if (direction.equals("OUT")){
                if (carsRegistrationSet.contains(carRegistration)){
                    carsRegistrationSet.remove(carRegistration);
                }
            }

            input = scanner.nextLine().split(", ");

        }

        if (carsRegistrationSet.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String element : carsRegistrationSet) {
                System.out.println(element);
            }
        }



    }
}
