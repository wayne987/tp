package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDays.ALICE;
import static seedu.address.testutil.TypicalDays.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.day.Day;
import seedu.address.model.day.exceptions.DuplicateDayException;
import seedu.address.model.person.Person;
import seedu.address.model.person.Profile;
import seedu.address.testutil.DayBuilder;

public class MyFitnessBuddyTest {

    private final MyFitnessBuddy myFitnessBuddy = new MyFitnessBuddy();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), myFitnessBuddy.getPerson());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> myFitnessBuddy.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        MyFitnessBuddy newData = getTypicalAddressBook();
        myFitnessBuddy.resetData(newData);
        assertEquals(newData, myFitnessBuddy);
    }

    @Test
    public void resetData_withDuplicateDays_throwsDuplicateDayException() {
        // Two days with the same identity fields
        Day editedAlice = new DayBuilder(ALICE).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Day> newDays = Arrays.asList(ALICE, editedAlice);
//        MyFitnessBuddyStub newData = new MyFitnessBuddyStub(newDays);
//
//        assertThrows(DuplicateDayException.class, () -> myFitnessBuddy.resetData(newData));
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
        //private final ObservableList<Person> personList = FXCollections.observableArrayList();
        private Person person;
//        MyFitnessBuddyStub(Collection<Day> personList) {
//            this.personList.setAll(personList);
//        }

        MyFitnessBuddyStub(Person person) {
            this.person = person;
        }

        @Override
        public Person getPerson() {
            return person;
        }

        @Override
        public Profile getProfile() {
            return getPerson().getProfile();
        }

//        @Override
//        public ObservableList<Person> getPerson() {
//            return personList;
//        }

    }

}
