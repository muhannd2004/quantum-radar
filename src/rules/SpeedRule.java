package rules;

import enums.CarType;
import model.Observation;
import model.Violation;

public class SpeedRule implements Rule{
    private String name;
    private double speedLimit;
    private double fee;
    private CarType carType;

    public SpeedRule(String name, double speedLimit, double fee, CarType carType) {
        this.name = name;
        this.speedLimit = speedLimit;
        this.fee = fee;
        this.carType = carType;
    }

    @Override
    public Violation check(Observation observation) {
        if(observation.getCarType() == this.carType && observation.getSpeed() > this.speedLimit){
            String description = "speed of " + observation.getSpeed() + " exceeded max allowed " + this.speedLimit + " : " + String.format("%.2f", this.fee) + " EGP";
            return new Violation(this.name, this.fee, description);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    // getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
