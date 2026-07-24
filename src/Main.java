import enums.CarType;
import enums.SeatbeltStatus;
import model.Fine;
import model.Observation;
import repository.RadarsManager;
import rules.PrivateCarSpeedRule;
import rules.Rule;
import rules.SeatbeltRule;
import rules.TruckSpeedRule;
import service.Radar;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){

        Observation observation1 = new Observation("123", LocalDate.now(), CarType.PRIVATE, 80, SeatbeltStatus.NOT);
        Rule rule1 = new PrivateCarSpeedRule("private car Speed rule", 50, 100);
        Rule rule2 = new SeatbeltRule("Seatbelt Rule", 800);
        Rule rule3 = new TruckSpeedRule("Truck Speed rule", 40, 1000);

        List<Rule> rules = List.of(rule1, rule2, rule3);

        RadarsManager radarsManager = RadarsManager.getInstance();

        Radar radar = new Radar(rules, radarsManager);

        Fine fine = radar.check(observation1);
        fine.generateFine();

        System.out.println("================================");
        radarsManager.getFines();
        System.out.println("================================");
        radarsManager.getViolations();
    }
}
