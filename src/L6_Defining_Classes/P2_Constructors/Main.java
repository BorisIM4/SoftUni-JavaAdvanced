package L6_Defining_Classes.P2_Constructors;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> listOfCars = new LinkedList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int car = 0; car < numberOfCars; car++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];
            if (tokens.length == 1) {
                Car currentCar = new Car(brand);
                listOfCars.add(currentCar);
            } else {
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                Car currnetCar = new Car(brand, model, horsePower);
                listOfCars.add(currnetCar);
            }

        }

        for (Car car : listOfCars) {
            String brand = car.getBrand();
            String model = car.getModel();
            int horsePower = car.getHorsePower();

            System.out.printf("The car is: %s %s - %d HP."
                    , brand
                    , model
                    , horsePower);
            System.out.println();
        }
    }
}
