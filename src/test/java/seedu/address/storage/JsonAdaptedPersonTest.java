package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedPerson.MESSAGE_DUPLICATE_DAY;
import static seedu.address.storage.JsonAdaptedPerson.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.day.Day;
import seedu.address.model.person.Person;
import seedu.address.model.person.Profile;
import seedu.address.testutil.TypicalDays;
import seedu.address.testutil.TypicalPerson;
import seedu.address.testutil.TypicalProfiles;

public class JsonAdaptedPersonTest {
    private static final Profile VALID_PROFILE = TypicalProfiles.VALID_PROFILE;
    private static final List<Day> VALID_DAYS = TypicalDays.getTypicalDays();
    private static final Person VALID_PERSON = TypicalPerson.VALID_PERSON;

    private static final List<Day> INVALID_DAYS = TypicalDays.getDuplicateDays();

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_PERSON);
        assertEquals(VALID_PERSON, person.toModelType());
    }

    @Test
    public void toModelType_nullProfile_throwsIllegalValueException() {

        JsonAdaptedPerson person = new JsonAdaptedPerson(null, VALID_DAYS.stream()
                .map(JsonAdaptedDay::new).collect(Collectors.toList()));
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Profile.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullDays_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(new JsonAdaptedProfile(VALID_PROFILE), null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Day.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidDays_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(new JsonAdaptedProfile(VALID_PROFILE),
                INVALID_DAYS.stream().map(JsonAdaptedDay::new).collect(Collectors.toList()));;
        String expectedMessage = MESSAGE_DUPLICATE_DAY;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }
}
