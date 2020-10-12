package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WEIGHT_1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WEIGHT_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.day.Day;

/**
 * A utility class containing a list of {@code Day} objects to be used in tests.
 */
public class TypicalDays {

    public static final Day ALICE = new DayBuilder().withDate("010120")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("alice@example.com")
            .withWeight("45")
            .withTags("friends").build();
    public static final Day BENSON = new DayBuilder().withDate("020120")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com").withWeight("80")
            .withTags("owesMoney", "friends").build();
    public static final Day CARL = new DayBuilder().withDate("030120").withWeight("75")
            .withEmail("heinz@example.com").withAddress("wall street").build();
    public static final Day DANIEL = new DayBuilder().withDate("040120").withWeight("66")
            .withEmail("cornelia@example.com").withAddress("10th street").withTags("friends").build();
    public static final Day ELLE = new DayBuilder().withDate("050120").withWeight("42")
            .withEmail("werner@example.com").withAddress("michegan ave").build();
    public static final Day FIONA = new DayBuilder().withDate("060120").withWeight("51")
            .withEmail("lydia@example.com").withAddress("little tokyo").build();
    public static final Day GEORGE = new DayBuilder().withDate("070120").withWeight("73")
            .withEmail("anna@example.com").withAddress("4th street").build();

    // Manually added
    public static final Day HOON = new DayBuilder().withDate("080120").withWeight("56")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Day IDA = new DayBuilder().withDate("090120").withWeight("40")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Day's details found in {@code CommandTestUtil}
    public static final Day AMY = new DayBuilder().withDate(VALID_DATE_1).withWeight(VALID_WEIGHT_1)
            .withEmail(VALID_EMAIL_1).withAddress(VALID_ADDRESS_1).withTags(VALID_TAG_FRIEND).build();
    public static final Day BOB = new DayBuilder().withDate(VALID_DATE_2).withWeight(VALID_WEIGHT_2)
            .withEmail(VALID_EMAIL_2).withAddress(VALID_ADDRESS_2).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalDays() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical days.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Day day : getTypicalDays()) {
            ab.addDay(day);
        }
        return ab;
    }

    public static List<Day> getTypicalDays() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
