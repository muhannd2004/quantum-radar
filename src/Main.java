import enums.CarType;
import enums.SeatbeltStatus;
import model.Fine;
import model.Observation;
import repository.RadarsManager;
import rules.*;
import service.Radar;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){

        Rule rule1 = new SpeedRule("private car Speed rule", 80, 100, CarType.PRIVATE);
        Rule rule2 = new SeatbeltRule("Seatbelt Rule", 800);
        Rule rule3 = new SpeedRule("Truck Speed rule", 60, 1000, CarType.TRUCK);
        Rule rule4 = new SpeedRule("Bus Speed rule", 70, 500, CarType.BUS);

        List<Rule> rules = List.of(rule1, rule2, rule3, rule4);

        RadarsManager radarsManager = RadarsManager.getInstance();

        Radar radar = new Radar(rules, radarsManager);

        Observation o1 = new Observation("111", LocalDate.now(), CarType.PRIVATE, 90, SeatbeltStatus.FASTENED);
        Observation o2 = new Observation("222", LocalDate.now(), CarType.TRUCK, 60, SeatbeltStatus.FASTENED);

        System.out.println("*****************");
        radar.check(o1).generateFine();
        System.out.println();
        System.out.println("*****************");
        radar.check(o2).generateFine();
        System.out.println();

        System.out.println("================================");
        radarsManager.getFines();
        System.out.println();
        System.out.println("*****************");
        radarsManager.getViolations();
        System.out.println("================================");

        Observation o3 = new Observation("333", LocalDate.now(), CarType.PRIVATE, 80, SeatbeltStatus.NOT_FASTENED);
        Observation o4 = new Observation("444", LocalDate.now(), CarType.TRUCK, 90, SeatbeltStatus.NOT_FASTENED);
        Observation o5 = new Observation("555", LocalDate.now(), CarType.BUS, 100, SeatbeltStatus.FASTENED);

        System.out.println();
        System.out.println("*****************");
        radar.check(o3).generateFine();
        System.out.println();
        System.out.println("*****************");
        radar.check(o4).generateFine();
        System.out.println();
        System.out.println("*****************");
        radar.check(o5).generateFine();
        System.out.println();

        System.out.println("================================");
        radarsManager.getFines();
        System.out.println();
        System.out.println("*****************");
        radarsManager.getViolations();
    }
}
