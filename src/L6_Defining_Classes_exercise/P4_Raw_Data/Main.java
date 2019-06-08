package L6_Defining_Classes_exercise.P4_Raw_Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Car currentCar = new Car();

            //car model
            String model = tokens[0];
            currentCar.setModel(model);
            //car engine
            int engineSpeed = Integer.parseInt(tokens[1]);
            currentCar.getEngine().setSpeed(engineSpeed);
            int enginePower = Integer.parseInt(tokens[2]);
            currentCar.getEngine().setPower(enginePower);
            //car cargo
            int cargoWeight = Integer.parseInt(tokens[3]);
            currentCar.getCargo().setCargoWeight(cargoWeight);
            String cargoType = tokens[4];
            currentCar.getCargo().setCargoType(cargoType);
            //car tires 1
            double tire1Presure = Double.parseDouble(tokens[5]);
            currentCar.getTires().setTire1Presure(tire1Presure);
            int tire1Age = Integer.parseInt(tokens[6]);
            currentCar.getTires().setTire1Age(tire1Age);
            //car tires 2
            double tire2Presure = Double.parseDouble(tokens[7]);
            currentCar.getTires().setTire2Presure(tire2Presure);
            int tire2Age = Integer.parseInt(tokens[8]);
            currentCar.getTires().setTire2Age(tire2Age);
            //car tires 3
            double tire3Presure = Double.parseDouble(tokens[9]);
            currentCar.getTires().setTire3Presure(tire3Presure);
            int tire3Age = Integer.parseInt(tokens[10]);
            currentCar.getTires().setTire3Age(tire3Age);
            //car tires 4
            double tire4Presure = Double.parseDouble(tokens[11]);
            currentCar.getTires().setTire4Presure(tire4Presure);
            int tire4Age = Integer.parseInt(tokens[12]);
            currentCar.getTires().setTire4Age(tire4Age);

            cars.add(currentCar);

        }

        String controlCargoType = scanner.nextLine();

        for (Car car : cars) {
            String currnetCarCargoType = car.getCargo().getCargoType();

            if (currnetCarCargoType.equals(controlCargoType) && currnetCarCargoType.equals("fragile")) {
                double currentCarTire1Presure = car.getTires().getTire1Presure();
                double currentCarTire2Presure = car.getTires().getTire2Presure();
                double currentCarTire3Presure = car.getTires().getTire3Presure();
                double currentCarTire4Presure = car.getTires().getTire4Presure();

                if (currentCarTire1Presure < 1
                        || currentCarTire2Presure < 1
                        || currentCarTire3Presure < 1
                        || currentCarTire4Presure < 1) {

                    System.out.println(car.getModel());
                }
            } else {
                int currentCarEnginePower = car.getEngine().getEnginPower();
                if (currentCarEnginePower > 250){
                    System.out.println(car.getModel());
                }
            }
        }

    }
}
