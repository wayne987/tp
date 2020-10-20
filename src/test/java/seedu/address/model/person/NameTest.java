package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Name(null));
    }

    @Test
    public void constructor_invalidFood_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
    }

    @Test
    void isValidName() {
        // null Food
        assertThrows(NullPointerException.class, () -> Name.isValidName(null));

        // invalid Food
        assertFalse(Name.isValidName("")); // empty string
        assertFalse(Name.isValidName(" ")); // spaces only
        assertFalse(Name.isValidName("jonny@nus")); // contains special character


        // valid Food
        assertTrue(Name.isValidName("jonny")); // alphabets only
        assertTrue(Name.isValidName("jonny no 1")); // contains number and space
        assertTrue(Name.isValidName("jonny the man")); //contains number, alphabet and special char

    }
}
