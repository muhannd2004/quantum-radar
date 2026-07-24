package rules;

import model.Observation;
import model.Violation;

public interface Rule {
    Violation check(Observation observation);
}
