package L6_Defining_Classes_exercise.P4_Raw_Data_2;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Car> carsList = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Car currentCar = new Car();

            //car model
            String model = tokens[0];
            currentCar.setModel(model);
            //car engine
            int engineSpeed = Integer.parseInt(tokens[1]);
            currentCar.setSpeed(engineSpeed);
            int enginePower = Integer.parseInt(tokens[2]);
            currentCar.setPower(enginePower);
            //car cargo
            int cargoWeight = Integer.parseInt(tokens[3]);
            currentCar.setCargoWeight(cargoWeight);
            String cargoType = tokens[4];
            currentCar.setCargoType(cargoType);
            //car tires 1
            double tire1Presure = Double.parseDouble(tokens[5]);
            currentCar.setTire1Presure(tire1Presure);
            int tire1Age = Integer.parseInt(tokens[6]);
            currentCar.setTire1Age(tire1Age);
            //car tires 2
            double tire2Presure = Double.parseDouble(tokens[7]);
            currentCar.setTire2Presure(tire2Presure);
            int tire2Age = Integer.parseInt(tokens[8]);
            currentCar.setTire2Age(tire2Age);
            //car tires 3
            double tire3Presure = Double.parseDouble(tokens[9]);
            currentCar.setTire3Presure(tire3Presure);
            int tire3Age = Integer.parseInt(tokens[10]);
            currentCar.setTire3Age(tire3Age);
            //car tires 4
            double tire4Presure = Double.parseDouble(tokens[11]);
            currentCar.setTire4Presure(tire4Presure);
            int tire4Age = Integer.parseInt(tokens[12]);
            currentCar.setTire4Age(tire4Age);

            carsList.put(model, currentCar);

        }

        String controlword = scanner.nextLine();

        for (String car:carsList.keySet()) {
            String currentCarCargoType = carsList.get(car).getCargoType();
            if (controlword. equals("fragile") && currentCarCargoType.equals(controlword)){
                double currnetCarTire1Presure = carsList.get(car).getTire1Presure();
                double currnetCarTire2Presure = carsList.get(car).getTire2Presure();
                double currnetCarTire3Presure = carsList.get(car).getTire3Presure();
                double currnetCarTire4Presure = carsList.get(car).getTire4Presure();

                if (currnetCarTire1Presure < 1
                        || currnetCarTire2Presure < 1
                        || currnetCarTire3Presure < 1
                        || currnetCarTire4Presure < 1){

                    System.out.println(car);

                }

            } else if (controlword.equals("flamable") && currentCarCargoType.equals(controlword)){
                int currentCarEnginePOwer = carsList.get(car).getEnginePower();
                if (currentCarEnginePOwer > 250){
                    System.out.println(car);
                }
            }
        }
    }
}
