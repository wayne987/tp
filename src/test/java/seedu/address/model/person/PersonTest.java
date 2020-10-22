package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDays.ALICE;
import static seedu.address.testutil.TypicalDays.getTypicalMyFitnessBuddy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.MyFitnessBuddy;
import seedu.address.model.ReadOnlyMyFitnessBuddy;
import seedu.address.model.day.Day;
import seedu.address.model.day.Weight;
import seedu.address.model.day.exceptions.DuplicateDayException;
import seedu.address.testutil.DayBuilder;

public class PersonTest {

    private final MyFitnessBuddy myFitnessBuddy = new MyFitnessBuddy();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), myFitnessBuddy.getDayList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> myFitnessBuddy.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        MyFitnessBuddy newData = getTypicalMyFitnessBuddy();
        newData.setPerson(new Person(new Profile(new Name("Jon"), new ID("1222"), new Height("177"), new Weight("76"))));
        myFitnessBuddy.resetData(newData);
        assertEquals(newData, myFitnessBuddy);
    }

    @Test
    public void resetData_withDuplicateDays_throwsDuplicateDayException() {
        // Two days with the same identity fields
        Day editedAlice = new DayBuilder(ALICE).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Day> newDays = Arrays.asList(ALICE, editedAlice);
        MyFitnessBuddyStub newData = new MyFitnessBuddyStub(newDays);

        assertThrows(DuplicateDayException.class, () -> myFitnessBuddy.resetData(newData));
    }

    @Test
    public void hasDay_nullDay_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> myFitnessBuddy.hasDay((Day) null));
    }

    @Test
    public void hasDay_dayNotInAddressBook_returnsFalse() {
        assertFalse(myFitnessBuddy.hasDay(ALICE));
    }

    @Test
    public void hasDay_dayInAddressBook_returnsTrue() {
        myFitnessBuddy.addDay(ALICE);
        assertTrue(myFitnessBuddy.hasDay(ALICE));
    }

    @Test
    public void hasDay_dayWithSameIdentityFieldsInAddressBook_returnsTrue() {
        myFitnessBuddy.addDay(ALICE);
        Day editedAlice = new DayBuilder(ALICE).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(myFitnessBuddy.hasDay(editedAlice));
    }

    @Test
    public void getDayList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> myFitnessBuddy.getDayList().remove(0));
    }

    /**
     * A stub ReadOnlyAddressBook whose days list can violate interface constraints.
     */
    private static class MyFitnessBuddyStub implements ReadOnlyMyFitnessBuddy {
        private final ObservableList<Day> days = FXCollections.observableArrayList();
        private Profile profile = new Profile(new Name("Jon"), new ID("1222"), new Height("177"), new Weight("76"));
        private Person person;

        MyFitnessBuddyStub(Collection<Day> days) {
            this.days.setAll(days);
            this.person = new Person(profile);
        }

        @Override
        public ObservableList<Day> getDayList() {
            return days;
        }

        @Override
        public Profile getProfile() {
            return profile;
        }

        @Override
        public Person getPerson() {
            return null;
        }
    }

}
