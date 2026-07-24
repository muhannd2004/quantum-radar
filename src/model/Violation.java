package model;

public class Violation {
    private String name;
    private double fee;
    private String description;

    public Violation(String name, double fee, String description) {
        this.name = name;
        this.fee = fee;
        this.description = description;
    }

    // getters and setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
