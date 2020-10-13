package seedu.address.model.day.calorie;

public class Calorie {
    // Identity fields
    private CalorieCount calorieCount;
    private Time time;
    /**
     * Every field must be present and not null.
     */
    public Calorie(CalorieCount calorieCount, Time time) {
        this.calorieCount = calorieCount;
        this.time = time;
    }
    public CalorieCount getCalorieCount() {
        return calorieCount;
    }

    public Time getTime() {
        return time;
    }
}
