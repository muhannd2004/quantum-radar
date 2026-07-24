package model;

import java.util.List;
import java.util.stream.Collectors;

public class Fine {
    private String plateNumber;
    private double totalFee;
    private List<Violation> violations;

    public Fine(String plateNumber, double totalFee, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.totalFee = totalFee;
        this.violations = violations;
    }

    public void generateFine(){
        if (violations.isEmpty()) {
            System.out.println("No Fines Yet");
            return;
        }

        System.out.println(
                "traffic fine for car " + this.plateNumber + "\n"
                + "Total amount: " + String.format("%.2f", this.totalFee) + "\n"
                + "Violations:\n- "
                + violations.stream()
                        .map(Violation::getDescription)
                        .collect(Collectors.joining("\n- "))
        );
    }

    // getters and setters
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }
}
