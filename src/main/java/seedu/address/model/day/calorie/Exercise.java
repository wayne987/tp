package seedu.address.model.day.calorie;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Exercise {
    public static final String MESSAGE_CONSTRAINTS =
            "Exercise can take any values, and it should not be blank";

    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String exercise;

    /**
     * Constructs a {@code Exercise}.
     *
     * @param exercise A valid exercise.
     */
    public Exercise(String exercise) {
        requireNonNull(exercise);
        checkArgument(isValidExercise(exercise), MESSAGE_CONSTRAINTS);
        this.exercise = exercise;
    }

    public static boolean isValidExercise(String test) {
        assert test != null : "test cannot be null";
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return exercise;
    }

}
