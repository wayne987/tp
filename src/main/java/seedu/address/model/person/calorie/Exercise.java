package seedu.address.model.person.calorie;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Exercise {
    public static final String MESSAGE_CONSTRAINTS =
            "Exercise can take any values, and it should not be blank";

    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String EXERCISE;

    public Exercise(String exercise) {
        requireNonNull(exercise);
        checkArgument(isValidExercise(exercise), MESSAGE_CONSTRAINTS);
        EXERCISE = exercise;
    }

    public static boolean isValidExercise(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return EXERCISE;
    }

}
