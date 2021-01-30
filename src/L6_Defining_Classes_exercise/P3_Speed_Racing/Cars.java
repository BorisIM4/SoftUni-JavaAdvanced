package L6_Defining_Classes_exercise.P3_Speed_Racing;

public class Cars {
    private String carModel;
    private double gasTankSize;
    private double fuelCostFor1km;
    private double traveledKm;

    public Cars (String name, int tankSize, double fuelCost) {
        this.carModel = name;
        this.gasTankSize = tankSize;
        this.fuelCostFor1km = fuelCost;
    }

    public double getFuelCostFor1km() {
        return fuelCostFor1km;
    }

    public double getGasTankSize() {
        return gasTankSize;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getTraveledKm() {
        return traveledKm;
    }

    public void setGasTankSize(double gasTankSize) {
        this.gasTankSize = gasTankSize;
    }

    public void setTraveledKm(double traveledKm) {
        this.traveledKm += traveledKm;
    }
}
