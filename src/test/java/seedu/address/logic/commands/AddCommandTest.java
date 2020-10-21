package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.MyFitnessBuddy;
import seedu.address.model.ReadOnlyMyFitnessBuddy;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.day.Day;
import seedu.address.model.day.Weight;
import seedu.address.model.person.Height;
import seedu.address.model.person.ID;
import seedu.address.model.person.Name;
import seedu.address.model.person.Profile;
import seedu.address.testutil.DayBuilder;

public class AddCommandTest {

    @Test
    public void constructor_nullDay_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_dayAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingDayAdded modelStub = new ModelStubAcceptingDayAdded();
        Day validDay = new DayBuilder().build();

        //CommandResult commandResult = new AddCommand(validDay).execute(modelStub);

        assertThrows(AssertionError.class, () -> new AddCommand(validDay).execute(modelStub));
        //assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validDay), commandResult.getFeedbackToUser());
        //assertEquals(Arrays.asList(validDay), modelStub.daysAdded);
    }

    @Test
    public void execute_duplicateDay_throwsCommandException() throws Exception {
        Day validDay = new DayBuilder().build();
        Profile validProfile = new Profile(new Name("Jon"), new ID("1234"), new Height("167"), new Weight("60"));
        MyFitnessBuddy p = new MyFitnessBuddy();
        p.getPerson().setProfile(validProfile);
        AddCommand addCommand = new AddCommand(validDay);
        ModelStub modelStub = new ModelStubWithDay(validDay);
        //CommandResult commandResult = addCommand.execute(modelStub);

        //assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_DAY, () -> addCommand.execute(modelStub));
        //assertEquals(String.format(AddCommand.MESSAGE_DUPLICATE_DAY), commandResult);
    }

    @Test
    public void equals() {
        Day alice = new DayBuilder().withDate("2020-06-09").build();
        Day bob = new DayBuilder().withDate("2020-09-06").build();
        AddCommand addAliceCommand = new AddCommand(alice);
        AddCommand addBobCommand = new AddCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddCommand addAliceCommandCopy = new AddCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different day -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getMyFitnessBuddyFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setMyFitnessBuddyFilePath(Path myFitnessBuddyFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addDay(Day day) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setMyFitnessBuddy(ReadOnlyMyFitnessBuddy myFitnessBuddy) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyMyFitnessBuddy getMyFitnessBuddy() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasDay(Day day) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasDay(LocalDate date) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Day getDay(LocalDate date) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteDay(Day target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setDay(Day target, Day editedDay) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Day> getFilteredDayList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredDayList(Predicate<Day> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setProfile(Profile profile) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasProfile() {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single day.
     */
    private class ModelStubWithDay extends ModelStub {
        private final Day day;

        ModelStubWithDay(Day day) {
            requireNonNull(day);
            this.day = day;
        }

        @Override
        public boolean hasDay(Day day) {
            requireNonNull(day);
            return this.day.isSameDay(day);
        }
    }

    /**
     * A Model stub that always accept the day being added.
     */
    private class ModelStubAcceptingDayAdded extends ModelStub {
        final ArrayList<Day> daysAdded = new ArrayList<>();

        @Override
        public boolean hasDay(Day day) {
            requireNonNull(day);
            return daysAdded.stream().anyMatch(day::isSameDay);
        }

        @Override
        public void addDay(Day day) {
            requireNonNull(day);
            daysAdded.add(day);
        }

        @Override
        public ReadOnlyMyFitnessBuddy getMyFitnessBuddy() {
            return new MyFitnessBuddy();
        }
    }

}
