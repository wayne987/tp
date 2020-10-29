package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Id in the profile.
 * Guarantees: immutable; is valid as declared in {@link #isValidId(String)}
 */
public class ID {

    public static final String MESSAGE_CONSTRAINTS =
            "ID should only contain 4 digit.";
    public static final String VALIDATION_REGEX = "\\d{4}";
    public static final String VALIDATION_REGEX_FIRST_TWO_INDEX = "[1-4]";
    public static final int VALIDATION_REGEX_LOWER_LIMIT = 1;
    public static final int VALIDATION_REGEX_UPPER_LIMIT = 20;
    public final String value;

    /**
     * Constructs a {@code ID}.
     *
     * @param id A valid id.
     */
    public ID(String id) {
        requireNonNull(id);
        checkArgument(isValidId(id), MESSAGE_CONSTRAINTS);
        value = id;
    }

    /**
     * Returns true if a given string is a valid Id number.
     */
    public static boolean isValidId(String test) {
        assert test.length() > 3;
        if (test.matches(VALIDATION_REGEX)) {
            int firstIndex = Integer.parseInt(test.substring(0, 1));
            int secondIndex = Integer.parseInt(test.substring(1, 2));
            int value = Integer.parseInt(test.substring(2, 4));
            return firstIndex > 0
                    && firstIndex < 5
                    && secondIndex > 0
                    && secondIndex < 5
                    && value > 0
                    && value < 21;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ID // instanceof handles nulls
                && value.equals(((ID) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
