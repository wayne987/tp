package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.day.Day;
import seedu.address.model.person.Profile;

/**
 * Represents the in-memory model of the person data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final Person person;
    private final UserPrefs userPrefs;
    private final FilteredList<Day> filteredDays;

    /**
     * Initializes a ModelManager with the given person and userPrefs.
     */
    public ModelManager(ReadOnlyPerson readOnlyPerson, ReadOnlyUserPrefs userPrefs) {
        super();
        requireAllNonNull(readOnlyPerson, userPrefs);

        logger.fine("Initializing with person: " + readOnlyPerson + " and user prefs " + userPrefs);

        this.person = new Person(readOnlyPerson);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredDays = new FilteredList<>(this.person.getDayList());
    }

    public ModelManager() {
        this(new Person(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getPersonFilePath() {
        return userPrefs.getPersonFilePath();
    }

    @Override
    public void setPersonFilePath(Path personFilePath) {
        requireNonNull(personFilePath);
        userPrefs.setPersonFilePath(personFilePath);
    }

    //=========== Person ================================================================================

    @Override
    public void setPerson(ReadOnlyPerson person) {
        this.person.resetData(person);
    }

    @Override
    public ReadOnlyPerson getPerson() {
        return person;
    }

    @Override
    public boolean hasDay(Day day) {
        requireNonNull(day);
        return person.hasDay(day);
    }

    @Override
    public boolean hasDay(LocalDate date) {
        return person.hasDay(date);
    }

    @Override
    public Day getDay(LocalDate date) {
        return addressBook.getDay(date);
    }

    @Override
    public void deleteDay(Day target) {
        person.removeDay(target);
    }

    @Override
    public void addDay(Day day) {
        person.addDay(day);
        updateFilteredDayList(PREDICATE_SHOW_ALL_DAYS);
    }

    @Override
    public void setDay(Day target, Day editedDay) {
        requireAllNonNull(target, editedDay);

        person.setDay(target, editedDay);
    }

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Day> getFilteredDayList() {
        return filteredDays;
    }

    @Override
    public void updateFilteredDayList(Predicate<Day> predicate) {
        requireNonNull(predicate);
        filteredDays.setPredicate(predicate);
    }

    @Override
    public void setProfile(Profile profile) {
        person.setProfile(profile);
    }

    @Override
    public boolean hasProfile() {
        return person.hasProfile();
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return person.equals(other.person)
                && userPrefs.equals(other.userPrefs)
                && filteredDays.equals(other.filteredDays);
    }

}
