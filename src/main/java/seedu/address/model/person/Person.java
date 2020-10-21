package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javafx.collections.ObservableList;
import seedu.address.model.day.Day;
import seedu.address.model.day.UniqueDayList;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private Profile profile;
    private final UniqueDayList days;

    /**
     * Every field must be present and not null.
     */
    public Person(Profile profile, UniqueDayList days) {
        requireAllNonNull(profile, days);
        this.profile = profile;
        this.days = days;
    }

    public Person(Profile profile) {
        this.profile = profile;
        this.days = new UniqueDayList();
    }

    public Profile getProfile() {
        return profile;
    }

    public ObservableList<Day> getDayList() {
        return days.asUnmodifiableObservableList();
    }

    /**
     * Replaces the contents of the day list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setDays(List<Day> days) {
        this.days.setDays(days);
    }

    /**
     * Sets the profile information of current data to {@code profile}.
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Checks if the current data {@code Person } has a profile.
     */
    public boolean hasProfile() {
        return profile != null;
    }
    /**
     * Returns true if a day with the same identity as {@code day} exists in the my fitness buddy records.
     */
    public boolean hasDay(Day day) {
        requireNonNull(day);
        return days.contains(day);
    }

    /**
     * Returns true if a day in the my fitness buddy records with the same date as the current date.
     */
    public boolean hasDay(LocalDate date) {
        return days.contains(date);
    }

    /**
     * get a day in the my fitness buddy records with a specific date
     */
    public Day getDay(LocalDate date) {
        return days.getDate(date);
    }

    /**
     * Adds a day to the my fitness buddy records.
     * The day must not already exist in the my fitness buddy records.
     */
    public void addDay(Day p) {
        days.add(p);
    }

    /**
     * Replaces the given day {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the my fitness buddy records.
     * The day identity of {@code editedPerson} must not be the same as another existing day in the my fitness buddy records.
     */
    public void setDay(Day target, Day editedDay) {
        requireNonNull(editedDay);

        days.setDay(target, editedDay);
    }

    /**
     * Removes {@code key} from this {@code MyFitnessBuddy}.
     * {@code key} must exist in the records.
     */
    public void removeDay(Day key) {
        days.remove(key);
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getProfile().getId().equals(getProfile().getId()); // check is same id
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getProfile().getId().equals(getProfile().getId())
                && otherPerson.getProfile().getName().equals(getProfile().getName())
                && otherPerson.getProfile().getHeight().equals(getProfile().getHeight())
                && otherPerson.getProfile().getTargetWeight().equals(getProfile().getTargetWeight())
                && otherPerson.getDayList().equals(getDayList());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(profile, days);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Profile: ")
                .append(getProfile().toString())
                .append(" Days: ")
                .append(getDayList());
        return builder.toString();
    }

}
