package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Id in the profile.
 * Guarantees: immutable; is valid as declared in {@link #isValidId(String)}
 */
public class ID {

    public static final String MESSAGE_CONSTRAINTS =
            "ID should only contain numbers, and it should be 4 digits long. ";
    public static final String VALIDATION_REGEX = "\\d{4}";
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
        return test.matches(VALIDATION_REGEX);
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
