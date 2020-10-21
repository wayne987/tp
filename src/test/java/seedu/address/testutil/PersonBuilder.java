package seedu.address.testutil;

import seedu.address.model.MyFitnessBuddy;
import seedu.address.model.day.Day;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class PersonBuilder {

    private MyFitnessBuddy person;

    public PersonBuilder() {
        person = new MyFitnessBuddy();
    }

    public PersonBuilder(MyFitnessBuddy person) {
        this.person = person;
    }

    /**
     * Adds a new {@code Day} to the {@code AddressBook} that we are building.
     */
    public PersonBuilder withDay(Day day) {
        person.addDay(day);
        return this;
    }

    public MyFitnessBuddy build() {
        return person;
    }
}
