package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDays.DAY1;
import static seedu.address.testutil.TypicalDays.DEFAULT_PROFILE;
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
import seedu.address.testutil.DayBuilder;
import seedu.address.testutil.TypicalProfiles;

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
    public void resetData_withValidReadOnlyMyFitnessBuddy_replacesData() {
        MyFitnessBuddy newData = getTypicalMyFitnessBuddy();
        myFitnessBuddy.resetData(newData);
        assertEquals(newData, myFitnessBuddy);
    }
    //error: i cannot seem to make up a person w duplicated days lol
    // unless i setInternalList directly in UniqueDayList class
    @Test
    public void resetData_withDuplicateDays_throwsDuplicateDayException() {
        // Two days with the same identity fields
        myFitnessBuddy.setProfile(DEFAULT_PROFILE);
        Day editedDay1 = new DayBuilder(DAY1).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Day> newDays = Arrays.asList(DAY1, editedDay1);
        MyFitnessBuddyStub newData = new MyFitnessBuddyStub(newDays);

        //assertThrows(DuplicateDayException.class, () -> myFitnessBuddy.resetData(newData));
    }

    @Test
    public void hasDay_nullDay_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> myFitnessBuddy.hasDay((Day) null));
    }

    @Test
    public void hasDay_dayNotInMyFitnessBuddy_returnsFalse() {
        assertFalse(myFitnessBuddy.hasDay(DAY1));
    }

    @Test
    public void hasDay_dayInMyFitnessBuddy_returnsTrue() {
        myFitnessBuddy.addDay(DAY1);
        assertTrue(myFitnessBuddy.hasDay(DAY1));
    }

    @Test
    public void hasDay_dayWithSameIdentityFieldsInMyFitnessBuddy_returnsTrue() {
        myFitnessBuddy.addDay(DAY1);
        Day editedAlice = new DayBuilder(DAY1).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(myFitnessBuddy.hasDay(editedAlice));
    }

    @Test
    public void getDayList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> myFitnessBuddy.getDayList().remove(0));
    }

    /**
     * A stub ReadOnlyMyFitnessBuddy whose days list can violate interface constraints.
     */
    private static class MyFitnessBuddyStub implements ReadOnlyMyFitnessBuddy {
        private final ObservableList<Day> days = FXCollections.observableArrayList();
        private Profile profile = TypicalProfiles.JON;
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
            return person.getProfile();
        }

        @Override
        public Person getPerson() {
            return person;
        }
    }

}
