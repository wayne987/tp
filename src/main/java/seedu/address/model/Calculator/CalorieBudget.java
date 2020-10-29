package seedu.address.model.Calculator;

import seedu.address.model.day.Weight;
import seedu.address.model.person.Height;

public class CalorieBudget {

    /**
     * @param height of the person
     * @param weight of the person
     * @param age of the person
     * @return Basal Metabolic Rate in KCal
     */
    public static int calculateBasalMetabolic(Height height, Weight weight, int age) {
        double h = Integer.parseInt(height.value);
        double w = Integer.parseInt(weight.value);
        double bmr = 66.47 + (13.75 * w) + (5.003 * h) - (6.755 * age);
        return (int) bmr;
    }

    /**
     *
     * @param totalCalorieIn
     * @param totalCalorieOut
     * @param basalMetabolic
     * @return
     */
    public static int calculateCalorieSurplus(int totalCalorieIn, int totalCalorieOut, int basalMetabolic) {
        return totalCalorieIn + basalMetabolic - totalCalorieOut;
    }
}
