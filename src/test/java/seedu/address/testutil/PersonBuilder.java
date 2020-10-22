package seedu.address.testutil;

import seedu.address.model.person.Person;
import seedu.address.model.person.Profile;

/**
 * A utility class to help with building Person objects.
 * Example usage: <br>
 *     {@code Person ab = new PersonBuilder().withProfile(profile).build();}
 */
public class PersonBuilder {

    private Person person;

    public PersonBuilder() {
        person = new Person();
    }

    public PersonBuilder(Person person) {
        this.person = person;
    }

    /**
     * Adds a new {@code Day} to the {@code AddressBook} that we are building.
     */
    public PersonBuilder withProfile(Profile profile) {
        person.setProfile(profile);
        return this;
    }

    public Person build() {
        return person;
    }
}
