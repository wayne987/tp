package seedu.address.model.calorie;

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

    /**
     * Returns true if the current input happens after the input input
     */
    public boolean happenAfter(Input input) {
        return this.getTime().isAfter(input.getTime());
    }

    /**
     * Returns true if a otherInput has the same attributes as this Input
     * @param otherInput that is being checked with
     */
    public boolean isSameInput(Input otherInput) {
        return otherInput.getFood().food.equals(this.food.toString())
               && otherInput.getTime().time.equals(this.time.toString())
               && otherInput.getCalorieCount().calorieCount.equals(this.calorieCount.toString());
    }

}
