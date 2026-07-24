package service;

import model.Fine;
import model.Observation;
import model.Violation;
import repository.RadarsManager;
import rules.Rule;

import java.util.ArrayList;
import java.util.List;

public class Radar {
    List<Rule> rules;
    RadarsManager radarsManager;

    public Radar(List<Rule> rules, RadarsManager radarsManager) {
        this.rules = rules;
        this.radarsManager = radarsManager;
    }

    public Fine check(Observation observation){
        double totalFee = 0;
        List<Violation> violations = new ArrayList<>();
        for(Rule rule : rules){
            Violation violation = rule.check(observation);
            if(violation != null){
                violations.add(violation);
                totalFee += violation.getFee();
            }
        }
        Fine fine = new Fine(observation.getPlateNumber(), totalFee, violations);
        radarsManager.addFine(fine);
        return fine;
    }
}
