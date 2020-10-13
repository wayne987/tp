package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.day.Day;

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
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a day with the same identity as {@code day} exists in the address book.
     */
    boolean hasDay(Day day);

    boolean hasDay();

    Day getDay();

    /**
     * Deletes the given day.
     * The day must exist in the address book.
     */
    void deleteDay(Day target);

    /**
     * Adds the given day.
     * {@code day} must not already exist in the address book.
     */
    void addDay(Day day);

    /**
     * Replaces the given day {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The day identity of {@code editedPerson} must not be the same as another existing day in the address book.
     */
    void setDay(Day target, Day editedDay);

    /** Returns an unmodifiable view of the filtered day list */
    ObservableList<Day> getFilteredDayList();

    /**
     * Updates the filter of the filtered day list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredDayList(Predicate<Day> predicate);
}
