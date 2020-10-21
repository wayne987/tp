package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.day.Day;
import seedu.address.model.person.Person;
import seedu.address.model.person.Profile;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyMyFitnessBuddy {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Day> getDayList();

    /**
     * Returns the profile of a person.
     */
    Profile getProfile();

    Person getPerson();
}
