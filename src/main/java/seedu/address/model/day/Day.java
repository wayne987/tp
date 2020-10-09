package seedu.address.model.day;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.day.calorie.Output;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Day {

    private LocalDate date;
    // private List<Input> calorieInputList;
    private List<Output> calorieOutputList;

    // Identity fields
    private final Name name;
    private final Weight weight;
    private final Email email;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Class constructor
     */
    public Day(Name name, Weight weight, Email email, Address address, Set<Tag> tags) {
        requireAllNonNull(name, weight, email, address, tags);
        this.name = name;
        this.weight = weight;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.date = LocalDate.now();
        this.calorieOutputList = new ArrayList<Output>();
        // this.calorieInputList = new ArrayList<Input>();
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Output> getCalorieOutputList() {
        return calorieOutputList;
    }

    //    public List<Input> getCalorieInputList() {
    //        return calorieInputList;
    //    }
    //
    //    public void addCalorieInput(Input calorieInput) {
    //        calorieInputList.add(calorieInput);
    //    }

    public void addCalorieOutput(Output calorieOutput) {
        calorieOutputList.add(calorieOutput);
    }

    public Name getName() {
        return name;
    }

    public Weight getWeight() {
        return weight;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons of the same name have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Day otherDay) {
        if (otherDay == this) {
            return true;
        }

        return otherDay != null
                && otherDay.getName().equals(getName())
                && (otherDay.getEmail().equals(getEmail()) || otherDay.getWeight().equals(getWeight()));
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

        if (!(other instanceof Day)) {
            return false;
        }

        Day otherDay = (Day) other;
        return otherDay.getName().equals(getName())
                && otherDay.getWeight().equals(getWeight())
                && otherDay.getEmail().equals(getEmail())
                && otherDay.getAddress().equals(getAddress())
                && otherDay.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, weight, email, address, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append(" Weight: ")
                .append(getWeight())
                .append(" Email: ")
                .append(getEmail())
                .append(" Address: ")
                .append(getAddress())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
