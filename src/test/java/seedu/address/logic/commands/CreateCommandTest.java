package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalDays.getTypicalMyFitnessBuddy;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.day.Weight;
import seedu.address.model.person.Height;
import seedu.address.model.person.ID;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Profile;
import seedu.address.testutil.TypicalProfiles;

class CreateCommandTest {

    private static final Profile JON = TypicalProfiles.JON;
    private static Profile defaultProfile =
            new Profile(new Name("Default"), new ID("0000"), new Height("170"), new Weight("50"));
    private Model model = new ModelManager(getTypicalMyFitnessBuddy(), new UserPrefs());

    @Test
    public void constructor_nullDay_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CreateCommand(null));
    }

    @Test
    public void execute_createProfile_createSuccessful() throws Exception {
        ModelManager expectedModel = new ModelManager(model.getMyFitnessBuddy(), new UserPrefs());
        model.setProfile(defaultProfile);
        CreateCommand createCommand = new CreateCommand(JON);
        String expectedMessage = String.format(CreateCommand.MESSAGE_SUCCESS, JON);

        assertCommandSuccess(createCommand, model, expectedMessage, expectedModel);
    }
    //    @Test
    public void execute_createExistingProfileFail_throwsCommandException() throws Exception {
        Profile validProfile = new Profile(new Name("Jon"), new ID("1235"), new Height("167"), new Weight("60"));
        CreateCommand createCommand = new CreateCommand(validProfile);
        ModelManager expectedModel = new ModelManager(model.getMyFitnessBuddy(), new UserPrefs());
        expectedModel.setCurrentPerson(new Person(validProfile));

        assertThrows(CommandException.class, () -> createCommand.execute(expectedModel));
    }

    @Test
    public void equals() {
        Profile alice = new Profile(new Name("John"), new ID("1234"), new Height("170"), new Weight("68"));
        Profile bob = new Profile(new Name("Johnny"), new ID("1324"), new Height("170"), new Weight("68"));
        CreateCommand addAliceCommand = new CreateCommand(alice);
        CreateCommand addBobCommand = new CreateCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        CreateCommand addAliceCommandCopy = new CreateCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different day -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }


}
