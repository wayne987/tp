package seedu.address.model.day.calorie;

import java.time.LocalDate;

public class Calorie {
    // Identity fields
    private CalorieCount calorieCount;
    private Time time;
    private LocalDate date;
    /**
     * Every field must be present and not null.
     */
    public Calorie(CalorieCount calorieCount, Time time) {
        this.calorieCount = calorieCount;
        this.time = time;
        this.date = LocalDate.now();
    }
    public CalorieCount getCalorieCount() {
        return calorieCount;
    }

    public Time getTime() {
        return time;
    }

    public LocalDate getDate() {
        return date;
    }
}
