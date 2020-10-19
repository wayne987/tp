package seedu.address.testutil;

import seedu.address.model.Person;
import seedu.address.model.day.Day;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private Person addressBook;

    public AddressBookBuilder() {
        addressBook = new Person();
    }

    public AddressBookBuilder(Person addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Day} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withDay(Day day) {
        addressBook.addDay(day);
        return this;
    }

    public Person build() {
        return addressBook;
    }
}
