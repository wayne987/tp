package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WEIGHT_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WEIGHT_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.day.Day;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Day ALICE = new PersonBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withWeight("45")
            .withTags("friends").build();
    public static final Day BENSON = new PersonBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withWeight("80")
            .withTags("owesMoney", "friends").build();
    public static final Day CARL = new PersonBuilder().withName("Carl Kurz").withWeight("75")
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Day DANIEL = new PersonBuilder().withName("Daniel Meier").withWeight("66")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends").build();
    public static final Day ELLE = new PersonBuilder().withName("Elle Meyer").withWeight("42")
            .withEmail("werner@example.com").withAddress("michegan ave").build();
    public static final Day FIONA = new PersonBuilder().withName("Fiona Kunz").withWeight("51")
            .withEmail("lydia@example.com").withAddress("little tokyo").build();
    public static final Day GEORGE = new PersonBuilder().withName("George Best").withWeight("73")
            .withEmail("anna@example.com").withAddress("4th street").build();

    // Manually added
    public static final Day HOON = new PersonBuilder().withName("Hoon Meier").withWeight("56")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Day IDA = new PersonBuilder().withName("Ida Mueller").withWeight("40")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Day AMY = new PersonBuilder().withName(VALID_NAME_AMY).withWeight(VALID_WEIGHT_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withTags(VALID_TAG_FRIEND).build();
    public static final Day BOB = new PersonBuilder().withName(VALID_NAME_BOB).withWeight(VALID_WEIGHT_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Day day : getTypicalPersons()) {
            ab.addDay(day);
        }
        return ab;
    }

    public static List<Day> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
