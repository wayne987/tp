package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.day.Weight;

/**
 * Represents a profile in the Person's records.
 */
public class Profile {

    // identity fields
    public final Name name;
    public final ID id;

    // data fields
    public final Height height;
    private Weight targetWeight;

    /**
     * Creates a profile.
     */
    public Profile(Name name, ID id, Height height, Weight targetWeight) {
        requireAllNonNull(name, id, height, targetWeight);
        this.name = name;
        this.id = id;
        this.height = height;
        this.targetWeight = targetWeight;
    }

    public Name getName() {
        return name;
    }

    public ID getId() {
        return id;
    }

    public Height getHeight() {
        return height;
    }

    public Weight getTargetWeight() {
        return targetWeight;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Name: ")
                .append(getName())
                .append(" ID: ")
                .append(getId())
                .append(" Height: ")
                .append(getHeight())
                .append(" Target Weight: ")
                .append(getTargetWeight());
        return builder.toString();
    }

}
