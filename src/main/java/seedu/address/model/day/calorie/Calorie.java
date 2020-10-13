package seedu.address.model.day.calorie;

public class Calorie {
    // Identity fields
    private CalorieCount calorieCount;

    /**
     * Every field must be present and not null.
     */
    public Calorie(CalorieCount calorieCount) {
        this.calorieCount = calorieCount;
    }
    public CalorieCount getCalorieCount() {
        return calorieCount;
    }
}
