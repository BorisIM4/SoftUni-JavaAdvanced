package L6_Defining_Classes.P1_Car_Info;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> carsList = new LinkedList<>();

        int numberOfcars = Integer.parseInt(scanner.nextLine());

        for (int cars = 0; cars < numberOfcars; cars++) {
            String[] inputDataCar = scanner.nextLine().split("\\s+");

            String currentCarBrand = inputDataCar[0];
            String currentCarModel = inputDataCar[1];
            int currentCarHorsePower = Integer.parseInt(inputDataCar[2]);

            Car car = new Car();
            car.setBrand(currentCarBrand);
            car.setModel(currentCarModel);
            car.setHorsePower(currentCarHorsePower);

            carsList.add(car);
        }

        for (Car car : carsList) {
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
