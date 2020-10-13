package seedu.address.model.day.calorie;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class Input extends Calorie {

    private Food food;

    /**
     * Every field must be present and not null.
     */
    public Input(Time time, Food food, CalorieCount calorieCount) {
        super(calorieCount, time);
        requireAllNonNull(food, time, calorieCount);
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Food: ")
                .append(getFood())
                .append(" Time: ")
                .append(getTime())
                .append(" Calorie Intake: ")
                .append(getCalorieCount());

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Input(new Time("1200"), new Food("Laksa"), new CalorieCount("400")));
    }
}
