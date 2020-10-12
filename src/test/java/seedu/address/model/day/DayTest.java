package seedu.address.model.day;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WEIGHT_2;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDays.ALICE;
import static seedu.address.testutil.TypicalDays.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.DayBuilder;

public class DayTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Day day = new DayBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> day.getTags().remove(0));
    }

    @Test
    public void isSameDay() {
        // same object -> returns true
        assertTrue(ALICE.isSameDay(ALICE));

        // null -> returns false
        assertFalse(ALICE.isSameDay(null));

        // different weight and email -> returns false
        Day editedAlice = new DayBuilder(ALICE).withWeight(VALID_WEIGHT_2).withEmail(VALID_EMAIL_2).build();
        assertFalse(ALICE.isSameDay(editedAlice));

        // different date -> returns false
        editedAlice = new DayBuilder(ALICE).withDate(VALID_DATE_2).build();
        assertFalse(ALICE.isSameDay(editedAlice));

        // same date, same weight, different attributes -> returns true
        editedAlice = new DayBuilder(ALICE).withEmail(VALID_EMAIL_2).withAddress(VALID_ADDRESS_2)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameDay(editedAlice));

        // same date, same email, different attributes -> returns true
        editedAlice = new DayBuilder(ALICE).withWeight(VALID_WEIGHT_2).withAddress(VALID_ADDRESS_2)
                .withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameDay(editedAlice));

        // same date, same weight, same email, different attributes -> returns true
        editedAlice = new DayBuilder(ALICE).withAddress(VALID_ADDRESS_2).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(ALICE.isSameDay(editedAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Day aliceCopy = new DayBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different day -> returns false
        assertFalse(ALICE.equals(BOB));

        // different date -> returns false
        Day editedAlice = new DayBuilder(ALICE).withDate(VALID_DATE_2).build();
        assertFalse(ALICE.equals(editedAlice));

        // different weight -> returns false
        editedAlice = new DayBuilder(ALICE).withWeight(VALID_WEIGHT_2).build();
        assertFalse(ALICE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new DayBuilder(ALICE).withEmail(VALID_EMAIL_2).build();
        assertFalse(ALICE.equals(editedAlice));

        // different address -> returns false
        editedAlice = new DayBuilder(ALICE).withAddress(VALID_ADDRESS_2).build();
        assertFalse(ALICE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new DayBuilder(ALICE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(ALICE.equals(editedAlice));
    }
}
