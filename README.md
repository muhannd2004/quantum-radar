# quantum-radar

## Design Patterns
* **Strategy Pattern (Rule):** Used to allow adding or modifying different types of traffic rules easily without changing the core radar logic.
* **Singleton Pattern (RadarsManager):** Used to ensure there is only one centralized manager keeping track of all fines and violations across the entire system.

## Sample Input
```java
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

```

## Sample Output
```bash
*****************
traffic fine for car 111
Total amount: 100.00
Violations:
- speed of 90.0 exceeded max allowed 80.0 : 100.00 EGP

*****************
No Fines

================================
Total Fine By Plate Number
111 ----------- 100.0 EGP

*****************
Total Number Of Violation Per Rule
private car Speed rule ----------- 1
================================
```

## How to Run
Run the following commands in your terminal:
```bash
mkdir -p bin
javac -d bin -sourcepath src src/Main.java
java -cp bin Main
```
