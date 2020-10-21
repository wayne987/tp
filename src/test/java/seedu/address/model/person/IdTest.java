package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class IdTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ID(null));
    }

    @Test
    public void constructor_invalidID_throwsIllegalArgumentException() {
        String invalidID = "";
        assertThrows(IllegalArgumentException.class, () -> new ID(invalidID));
    }

    @Test
    void isValidId() {
        // null Id
        assertThrows(NullPointerException.class, () -> ID.isValidId(null));

        // invalid Id
        assertFalse(ID.isValidId("")); // empty string
        assertFalse(ID.isValidId(" ")); // spaces only
        assertFalse(ID.isValidId("abc1"));

        // valid Id
        assertTrue(ID.isValidId("1234"));
        assertTrue(ID.isValidId("0123"));

    }
}
