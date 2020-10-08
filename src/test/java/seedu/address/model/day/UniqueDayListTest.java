package seedu.address.model.day;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.day.exceptions.DuplicatePersonException;
import seedu.address.model.day.exceptions.PersonNotFoundException;
import seedu.address.testutil.PersonBuilder;

public class UniqueDayListTest {

    private final UniqueDayList uniqueDayList = new UniqueDayList();

    @Test
    public void contains_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDayList.contains(null));
    }

    @Test
    public void contains_personNotInList_returnsFalse() {
        assertFalse(uniqueDayList.contains(ALICE));
    }

    @Test
    public void contains_personInList_returnsTrue() {
        uniqueDayList.add(ALICE);
        assertTrue(uniqueDayList.contains(ALICE));
    }

    @Test
    public void contains_personWithSameIdentityFieldsInList_returnsTrue() {
        uniqueDayList.add(ALICE);
        Day editedAlice = new PersonBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        assertTrue(uniqueDayList.contains(editedAlice));
    }

    @Test
    public void add_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDayList.add(null));
    }

    @Test
    public void add_duplicatePerson_throwsDuplicatePersonException() {
        uniqueDayList.add(ALICE);
        assertThrows(DuplicatePersonException.class, () -> uniqueDayList.add(ALICE));
    }

    @Test
    public void setPerson_nullTargetPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDayList.setDay(null, ALICE));
    }

    @Test
    public void setPerson_nullEditedPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDayList.setDay(ALICE, null));
    }

    @Test
    public void setPerson_targetPersonNotInList_throwsPersonNotFoundException() {
        assertThrows(PersonNotFoundException.class, () -> uniqueDayList.setDay(ALICE, ALICE));
    }

    @Test
    public void setPerson_editedPersonIsSamePerson_success() {
        uniqueDayList.add(ALICE);
        uniqueDayList.setDay(ALICE, ALICE);
        UniqueDayList expectedUniqueDayList = new UniqueDayList();
        expectedUniqueDayList.add(ALICE);
        assertEquals(expectedUniqueDayList, uniqueDayList);
    }

    @Test
    public void setPerson_editedPersonHasSameIdentity_success() {
        uniqueDayList.add(ALICE);
        Day editedAlice = new PersonBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        uniqueDayList.setDay(ALICE, editedAlice);
        UniqueDayList expectedUniqueDayList = new UniqueDayList();
        expectedUniqueDayList.add(editedAlice);
        assertEquals(expectedUniqueDayList, uniqueDayList);
    }

    @Test
    public void setPerson_editedPersonHasDifferentIdentity_success() {
        uniqueDayList.add(ALICE);
        uniqueDayList.setDay(ALICE, BOB);
        UniqueDayList expectedUniqueDayList = new UniqueDayList();
        expectedUniqueDayList.add(BOB);
        assertEquals(expectedUniqueDayList, uniqueDayList);
    }

    @Test
    public void setPerson_editedPersonHasNonUniqueIdentity_throwsDuplicatePersonException() {
        uniqueDayList.add(ALICE);
        uniqueDayList.add(BOB);
        assertThrows(DuplicatePersonException.class, () -> uniqueDayList.setDay(ALICE, BOB));
    }

    @Test
    public void remove_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDayList.remove(null));
    }

    @Test
    public void remove_personDoesNotExist_throwsPersonNotFoundException() {
        assertThrows(PersonNotFoundException.class, () -> uniqueDayList.remove(ALICE));
    }

    @Test
    public void remove_existingPerson_removesPerson() {
        uniqueDayList.add(ALICE);
        uniqueDayList.remove(ALICE);
        UniqueDayList expectedUniqueDayList = new UniqueDayList();
        assertEquals(expectedUniqueDayList, uniqueDayList);
    }

    @Test
    public void setPersons_nullUniquePersonList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDayList.setDays((UniqueDayList) null));
    }

    @Test
    public void setPersons_uniquePersonList_replacesOwnListWithProvidedUniquePersonList() {
        uniqueDayList.add(ALICE);
        UniqueDayList expectedUniqueDayList = new UniqueDayList();
        expectedUniqueDayList.add(BOB);
        uniqueDayList.setDays(expectedUniqueDayList);
        assertEquals(expectedUniqueDayList, uniqueDayList);
    }

    @Test
    public void setPersons_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueDayList.setDays((List<Day>) null));
    }

    @Test
    public void setPersons_list_replacesOwnListWithProvidedList() {
        uniqueDayList.add(ALICE);
        List<Day> dayList = Collections.singletonList(BOB);
        uniqueDayList.setDays(dayList);
        UniqueDayList expectedUniqueDayList = new UniqueDayList();
        expectedUniqueDayList.add(BOB);
        assertEquals(expectedUniqueDayList, uniqueDayList);
    }

    @Test
    public void setPersons_listWithDuplicatePersons_throwsDuplicatePersonException() {
        List<Day> listWithDuplicateDays = Arrays.asList(ALICE, ALICE);
        assertThrows(DuplicatePersonException.class, () -> uniqueDayList.setDays(listWithDuplicateDays));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, ()
            -> uniqueDayList.asUnmodifiableObservableList().remove(0));
    }
}
