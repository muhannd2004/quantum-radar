package rules;

import enums.SeatbeltStatus;
import model.Observation;
import model.Violation;

public class SeatbeltRule implements Rule{
    private String name;
    private double fee;

    public SeatbeltRule(String name, double fee) {
        this.name = name;
        this.fee = fee;
    }

    @Override
    public Violation check(Observation observation) {
        if(observation.getSeatbeltStatus() == SeatbeltStatus.NOT){
            String description = "Seatbelt not fastened : " + String.format("%.2f", this.fee) + " EGP";
            return new Violation(this.name, this.fee, description);
        }

        return null;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
