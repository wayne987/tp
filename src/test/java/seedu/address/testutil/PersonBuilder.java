package seedu.address.testutil;

import seedu.address.model.Person;
import seedu.address.model.day.Day;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
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
    public PersonBuilder withDay(Day day) {
        person.addDay(day);
        return this;
    }

    public Person build() {
        return person;
    }
}
