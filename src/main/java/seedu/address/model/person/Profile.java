package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.day.Weight;

/**
 * Represents a profile in My Fitness Buddy records.
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
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Profile)) {
            return false;
        }
        Profile otherProfile = (Profile) other;
        return otherProfile.getId().equals(getId())
                && otherProfile.getName().equals(getName())
                && otherProfile.getHeight().equals(getHeight())
                && otherProfile.getTargetWeight().equals(getTargetWeight());
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
