package seedu.address.model;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.day.Day;
import seedu.address.model.person.Profile;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Day> PREDICATE_SHOW_ALL_DAYS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' person file path.
     */
    Path getPersonFilePath();

    /**
     * Sets the user prefs' person file path.
     */
    void setPersonFilePath(Path personFilePath);

    /**
     * Replaces person data records with the data in {@code person}.
     */
    void setPerson(ReadOnlyPerson person);

    /** Returns the person */
    ReadOnlyPerson getPerson();

    /**
     * Returns true if a day with the same identity as {@code day} exists in the person.
     */
    boolean hasDay(Day day);

    boolean hasDay(LocalDate date);

    Day getDay();

    /**
     * Deletes the given day.
     * The day must exist in the person.
     */
    void deleteDay(Day target);

    /**
     * Adds the given day.
     * {@code day} must not already exist in the person.
     */
    void addDay(Day day);

    /**
     * Replaces the given day {@code target} with {@code editedPerson}.
     * {@code target} must exist in the person.
     * The day identity of {@code editedPerson} must not be the same as another existing day in the person.
     */
    void setDay(Day target, Day editedDay);

    /** Returns an unmodifiable view of the filtered day list */
    ObservableList<Day> getFilteredDayList();

    /**
     * Updates the filter of the filtered day list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredDayList(Predicate<Day> predicate);

    /**
     * Updates the profile of a person.
     */
    void setProfile(Profile profile);

    /**
     * Checks if the current data {@code Person} has a profile.
     */
    boolean hasProfile();
}
