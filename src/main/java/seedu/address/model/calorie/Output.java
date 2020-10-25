package seedu.address.model.calorie;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class Output extends Calorie {

    private Exercise exercise;
    /**
     * Every field must be present and not null.
     */
    public Output(Time time, Exercise exercise, CalorieCount calorieCount) {
        super(calorieCount, time);
        requireAllNonNull(exercise, time, calorieCount);
        this.exercise = exercise;
    }

    public Exercise getExercise() {
        return exercise;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Exercise: ")
                .append(getExercise())
                .append(" Time: ")
                .append(getTime())
                .append(" Calorie Burnt: ")
                .append(getCalorieCount());

        return builder.toString();
    }

    /**
     * Returns true if the current output happens after the input output
     */
    public boolean happenAfter(Output output) {
        return this.getTime().isAfter(output.getTime());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Output)) {
            return false;
        }

        Output otherInput = (Output) other;
        return otherInput.getCalorieCount().equals(getCalorieCount())
                && otherInput.getTime().equals(getTime())
                && otherInput.getExercise().equals(getExercise());
    }
}
