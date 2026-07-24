package model;

import enums.CarType;
import enums.SeatbeltStatus;

import java.time.LocalDate;

public class Observation {
    private String plateNumber;
    private LocalDate date;
    private CarType carType;
    private double speed;
    private SeatbeltStatus seatbeltStatus;

    public Observation(String plateNumber, LocalDate date, CarType carType, double speed, SeatbeltStatus seatbeltStatus) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltStatus = seatbeltStatus;
    }

    // getters and setters
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public SeatbeltStatus getSeatbeltStatus() {
        return seatbeltStatus;
    }

    public void setSeatbeltStatus(SeatbeltStatus seatbeltStatus) {
        this.seatbeltStatus = seatbeltStatus;
    }
}
