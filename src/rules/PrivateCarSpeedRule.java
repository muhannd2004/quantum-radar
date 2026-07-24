package rules;

import enums.CarType;
import model.Observation;
import model.Violation;

public class PrivateCarSpeedRule implements Rule{
    private String name;
    private double speedLimit;
    private double fee;

    public PrivateCarSpeedRule(String name, double speedLimit, double fee) {
        this.name = name;
        this.speedLimit = speedLimit;
        this.fee = fee;
    }

    @Override
    public Violation check(Observation observation) {
        if(observation.getCarType() == CarType.PRIVATE && observation.getSpeed() > this.speedLimit){
            String description = "speed of " + observation.getSpeed() + " exceeded max allowed " + this.speedLimit + " : " + String.format("%.2f", this.fee) + " EGP";
            return new Violation(this.name, this.fee, description);
        }
        return null;
    }

    // getters and setters
    public String getName() {
        return name;
    }

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
}
