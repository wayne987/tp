package seedu.address.model.day.calorie;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Food {

    public static final String MESSAGE_CONSTRAINTS =
            "Food can take any values, and it should not be blank";

    public static final String VALIDATION_REGEX = "[^\\s].*";

    public final String food;

    /**
     * Constructs a {@code Food}.
     *
     * @param food A valid food.
     */
    public Food(String food) {
        requireNonNull(food);
        checkArgument(isValidFood(food), MESSAGE_CONSTRAINTS);
        this.food = food;
    }

    public static boolean isValidFood(String test) {
        assert test != null : "test cannot be null";
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return food;
    }

}
