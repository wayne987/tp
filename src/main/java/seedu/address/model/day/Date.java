package seedu.address.model.day;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;

/**
 * Represents a Person's weight in the record.
 * Guarantees: immutable; is valid as declared in {@link #isValidDate(String)}
 */
public class Date {


    public static final String MESSAGE_CONSTRAINTS =
            "Date should be in the form of YYYY-MM-DD.";

    public final String value;

    private final LocalDate date;

    /**
     * Constructs a {@code Date}.
     *
     * @param date A valid date.
     */
    public Date(String date) {
        requireNonNull(date);
        checkArgument(isValidDate(date), MESSAGE_CONSTRAINTS);
        this.value = date;
        this.date = LocalDate.parse(date);
    }

    /**
     * Returns true if a given string is a valid weight number.
     */
    public static boolean isValidDate(String test) {
        try {
            LocalDate.parse(test);
            return true;
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * Returns the LocalDate stored in the Date class
     */
    public LocalDate get() {
        return date;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date) // instanceof handles nulls
                && date.equals(((Date) other).get()); // state check
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

}
