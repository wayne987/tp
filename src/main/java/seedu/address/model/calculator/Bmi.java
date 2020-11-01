package seedu.address.model.calculator;

import seedu.address.model.day.Weight;
import seedu.address.model.person.Height;

public class Bmi {

    /**
     *
     * @param height
     * @param weight
     * @return bmi
     */
    public static double calculateBmi(Height height, Weight weight) {
        double h = Integer.parseInt(height.value);
        double w = Integer.parseInt(weight.value);
        double bmi = w / ((h / 100) * (h / 100));
        return bmi;
    }
}
