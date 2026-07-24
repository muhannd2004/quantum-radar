package repository;

import model.Fine;
import model.Violation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadarsManager {
    private final Map<String, List<Fine>> carFines;
    private final Map<String, Long> violationsCount;

    private static RadarsManager instance;

    private RadarsManager(){
        this.carFines = new HashMap<>();
        this.violationsCount = new HashMap<>();
    }

    // assumed that it is thread safe not need for sync
    public static RadarsManager getInstance(){
        if(instance == null){
            instance = new RadarsManager();
        }
        return instance;
    }


    public void addFine(Fine fine){
        // if not found initialize this key and then add
        carFines.computeIfAbsent(fine.getPlateNumber(), k -> new ArrayList<>())
                .add(fine);

        for (Violation violation : fine.getViolations()) {
            // creates the key if not exist then adds one
            violationsCount.merge(violation.getName(), 1L, Long::sum);
        }
    }


    public void getFines(){
        System.out.println("Total Fine By Plate Number");
        for (String key : carFines.keySet()){
            double totalAmount = 0;
            for (Fine fine : carFines.get(key)){
                totalAmount += fine.getTotalFee();
            }
            System.out.println(key + " ----------- " + String.format("%.2f", totalAmount) + " EGP");
        }
    }

    public void getViolations(){
        System.out.println("Total Number Of Violation Per Rule");
        for(String key : violationsCount.keySet()){
            System.out.println(key + " ----------- " + violationsCount.get(key));
        }
    }
}
