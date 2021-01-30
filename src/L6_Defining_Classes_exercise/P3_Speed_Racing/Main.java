package L6_Defining_Classes_exercise.P3_Speed_Racing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        List<Cars> listOfCars = new LinkedList<>();

        for (int car = 0; car < numberOfCars; car++) {
            String[] tokenOfCurentCar = scanner.nextLine().split("\\s+");
            String nameOfCurrentCar = tokenOfCurentCar[0];
            int gasTankOfCurrentCar = Integer.parseInt(tokenOfCurentCar[1]);
            double fuelCostFor1km = Double.parseDouble(tokenOfCurentCar[2]);

            Cars currentCar = new Cars(nameOfCurrentCar, gasTankOfCurrentCar, fuelCostFor1km);
            listOfCars.add(currentCar);
        }

        String line = "";
        while (!"End".equals(line = scanner.nextLine())) {
            String[] token = line.split("\\s+");
            String carModel = token[1];
            double travelKm = Double.parseDouble(token[2]);

            for (int car = 0; car < listOfCars.size(); car++) {
                Cars currnetCar = listOfCars.get(car);
                if (carModel.equals(currnetCar.getCarModel())) {
                    double tankSizeCurrCar = currnetCar.getGasTankSize();
                    double fuelCostOfCurrCar = currnetCar.getFuelCostFor1km();
                    double kilometerMultiplyByCost = travelKm * fuelCostOfCurrCar;

                    if (kilometerMultiplyByCost > tankSizeCurrCar) {
                        System.out.println("Insufficient fuel for the drive");
                    } else {
                        double leftFuel = tankSizeCurrCar - kilometerMultiplyByCost;
                        currnetCar.setGasTankSize(leftFuel);
                        currnetCar.setTraveledKm(travelKm);
                    }
                }
            }
        }

        for (Cars currentCar : listOfCars) {
            String model = currentCar.getCarModel();
            double tankSize = currentCar.getGasTankSize();
            double traveledKm = currentCar.getTraveledKm();

            System.out.printf("%s %.2f %.0f%n"
                    , model
                    , tankSize
                    , traveledKm);

        }

    }
}
