package seedu.address.model.day;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Date(null));
    }

    @Test
    public void constructor_invalidDate_throwsIllegalArgumentException() {
        String invalidDate = "";
        assertThrows(IllegalArgumentException.class, () -> new Date(invalidDate));
    }

    @Test
    public void isValidDate() {
        // null date
        assertThrows(NullPointerException.class, () -> Date.isValidDate(null));

        // invalid date
        assertFalse(Date.isValidDate("")); // empty string
        assertFalse(Date.isValidDate(" ")); // spaces only
        assertFalse(Date.isValidDate("^")); // only non-alphanumeric characters
        assertFalse(Date.isValidDate("peter*")); // contains non-alphanumeric characters
        assertFalse(Date.isValidDate("peter jack")); // alphabets only
        assertFalse(Date.isValidDate("peter the 2nd")); // alphanumeric characters
        assertFalse(Date.isValidDate("Capital Tan")); // with capital letters
        assertFalse(Date.isValidDate("David Roger Jackson Ray Jr 2nd")); // long names

        // valid date
        assertTrue(Date.isValidDate("123455")); // numbers only
    }
}
