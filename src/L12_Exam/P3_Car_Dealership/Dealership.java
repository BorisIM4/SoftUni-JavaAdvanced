package L12_Exam.P3_Car_Dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;

    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Car car) {
        int listSize = data.size();
        if (capacity > listSize) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        boolean isRemoved = false;
        for (int car = 0; car < data.size(); car++) {
            Car currnetCar = data.get(car);

            String currentCarManufacturer = currnetCar.getManufacturer();
            String currentCarModel = currnetCar.getModel();

            if (currentCarManufacturer.equals(manufacturer) && currentCarModel.equals(model)) {
                data.remove(car);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public Car getLatestCar(){
        if (data.size() == 0) {
            return null;
        } else {
//            Car lastCar = data.get(data.size() - 1);
            Car lastCar = data.get(0);
            return lastCar;
        }
    }

    public Car getCar(String manufacturer, String model) {
        Car returnThatCar = null;
        if (data.size() > 0) {
            for (Car car : data) {
                String currentCarManufacturer = car.getManufacturer();
                String currentCarModel = car.getModel();

                if (currentCarManufacturer.equals(manufacturer) && currentCarModel.equals(model)) {
                    returnThatCar = car;
                }
            }
        }
        return returnThatCar;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("The cars are in a car dealership %s:" ,this.name));
        stringBuilder.append(System.lineSeparator());
        for (Car car : data) {
            stringBuilder.append(car);
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }

}
