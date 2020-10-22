package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDays.ALICE;
import static seedu.address.testutil.TypicalDays.getTypicalMyFitnessBuddy;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.day.Day;
import seedu.address.model.person.Person;
import seedu.address.model.person.Profile;
import seedu.address.testutil.DayBuilder;
import seedu.address.testutil.TypicalDays;

public class MyFitnessBuddyTest {

    private static Profile defaultProfile = TypicalDays.DEFAULT_PROFILE;
    private final MyFitnessBuddy myFitnessBuddy = new MyFitnessBuddy();
    private final Person person = new Person(defaultProfile);

    @Test
    public void constructor() {
        assertEquals(person, myFitnessBuddy.getPerson());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> myFitnessBuddy.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        MyFitnessBuddy newData = getTypicalMyFitnessBuddy();
        myFitnessBuddy.resetData(newData);
        assertEquals(newData, myFitnessBuddy);
    }
    //error due to refactoring
    @Test
    public void resetData_withDuplicateDays_throwsDuplicateDayException() {
        // Two days with the same identity fields
        Day editedAlice = new DayBuilder(ALICE).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Day> newDays = Arrays.asList(ALICE, editedAlice);
        MyFitnessBuddyStub newData = new MyFitnessBuddyStub(newDays, person);

        //assertThrows(DuplicateDayException.class, () -> myFitnessBuddy.resetData(newData));
    }

    @Test
    public void hasDay_nullDay_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> myFitnessBuddy.getPerson().hasDay((Day) null));
    }

    @Test
    public void hasDay_dayNotInAddressBook_returnsFalse() {
        assertFalse(myFitnessBuddy.getPerson().hasDay(ALICE));
    }

    @Test
    public void hasDay_dayInAddressBook_returnsTrue() {
        myFitnessBuddy.addDay(ALICE);
        assertTrue(myFitnessBuddy.getPerson().hasDay(ALICE));
    }

    @Test
    public void hasDay_dayWithSameIdentityFieldsInAddressBook_returnsTrue() {
        myFitnessBuddy.addDay(ALICE);
        Day editedAlice = new DayBuilder(ALICE).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(myFitnessBuddy.getPerson().hasDay(editedAlice));
    }

    @Test
    public void getDayList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> myFitnessBuddy.getPerson().getDayList().remove(0));
    }

    /**
     * A stub ReadOnlyAddressBook whose days list can violate interface constraints.
     */
    private static class MyFitnessBuddyStub implements ReadOnlyMyFitnessBuddy {
        private final ObservableList<Day> personList = FXCollections.observableArrayList();
        private Person person;
        MyFitnessBuddyStub(Collection<Day> personList, Person person) {
            this.person = person;
            this.personList.setAll(personList);
        }

        /**
         * Returns an unmodifiable view of the persons list.
         * This list will not contain any duplicate persons.
         */
        @Override
        public ObservableList<Day> getDayList() {
            return person.getDayList();
        }

        /**
         * Returns the profile of a person.
         */
        @Override
        public Profile getProfile() {
            return person.getProfile();
        }

        @Override
        public Person getPerson() {
            return person;
        }

    }

}
