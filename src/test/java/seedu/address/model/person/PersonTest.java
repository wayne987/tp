package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDays.DAY1;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.day.Day;
import seedu.address.testutil.DayBuilder;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.TypicalProfiles;

public class PersonTest {

    private final Person person = new PersonBuilder().build();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), person.getDayList());
        assertThrows(NullPointerException.class, () -> new Person(null));
        assertThrows(NullPointerException.class, () -> new Person(null, null));
        assertThrows(NullPointerException.class, () -> new Person(TypicalProfiles.VALID_PROFILE, null));
    }

    @Test
    public void hasDay_nullDay_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> person.hasDay((Day) null));
    }

    @Test
    public void hasDay_dayNotInPerson_returnsFalse() {
        assertFalse(person.hasDay(DAY1));
    }

    @Test
    public void hasDay_dayInPerson_returnsTrue() {
        person.addDay(DAY1);
        assertTrue(person.hasDay(DAY1));
        assertTrue(person.hasDay(DAY1.getDate().get()));
    }

    @Test
    public void hasDay_dayWithSameIdentityFieldsInPerson_returnsTrue() {
        person.addDay(DAY1);
        Day editedAlice = new DayBuilder(DAY1)
                .build();
        assertTrue(person.hasDay(editedAlice));
        assertTrue(person.hasDay(editedAlice.getDate().get()));
    }

    @Test
    public void isDefaultProfile() {
        Person personA = new PersonBuilder().withProfile(TypicalProfiles.VALID_PROFILE).build();

        assertTrue(person.isDefaultProfile());
        assertFalse(personA.isDefaultProfile());
    }

    @Test
    public void getDayList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> person.getDayList().remove(0));
    }

    @Test
    public void isSamePerson_returnsTrue() {
        Person personA = new PersonBuilder().build();
        Person personB = new PersonBuilder().withProfile(TypicalProfiles.VALID_PROFILE).build();
        assertFalse(personA.isSamePerson(personB));
        assertTrue(personA.isSamePerson(personA));
    }

    @Test
    void testEquals() {
        Person personA = new PersonBuilder().build();
        Person personB = new PersonBuilder().withProfile(TypicalProfiles.VALID_PROFILE).build();

        assertTrue(personA.equals(personA));
        assertFalse(personA.equals(personB));
        assertFalse(personA.equals(TypicalProfiles.DEFAULT_PROFILE));
        assertFalse(personA.equals(null));
        assertFalse(personA.equals(5));
    }

}
