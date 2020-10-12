package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_WEIGHT;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.day.Day;
import seedu.address.model.day.NameContainsKeywordsPredicate;
import seedu.address.testutil.EditDayDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_DATE_1 = "010120";
    public static final String VALID_DATE_2 = "020120";
    public static final String VALID_EMAIL_1 = "amy@example.com";
    public static final String VALID_EMAIL_2 = "bob@example.com";
    public static final String VALID_ADDRESS_1 = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_2 = "Block 123, Bobby Street 3";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";
    public static final String VALID_WEIGHT_1 = "45";
    public static final String VALID_WEIGHT_2 = "95";

    public static final String DATE_DESC_1 = " " + PREFIX_DATE + VALID_DATE_1;
    public static final String DATE_DESC_2 = " " + PREFIX_DATE + VALID_DATE_2;
    public static final String EMAIL_DESC_1 = " " + PREFIX_EMAIL + VALID_EMAIL_1;
    public static final String EMAIL_DESC_2 = " " + PREFIX_EMAIL + VALID_EMAIL_2;
    public static final String ADDRESS_DESC_1 = " " + PREFIX_ADDRESS + VALID_ADDRESS_1;
    public static final String ADDRESS_DESC_2 = " " + PREFIX_ADDRESS + VALID_ADDRESS_2;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;
    public static final String WEIGHT_DESC_1 = " " + PREFIX_WEIGHT + VALID_WEIGHT_1;
    public static final String WEIGHT_DESC_2 = " " + PREFIX_WEIGHT + VALID_WEIGHT_2;

    public static final String INVALID_DATE_DESC = " " + PREFIX_DATE + "erger&"; // '&' not allowed in dates
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags
    public static final String INVALID_WEIGHT_DESC = " " + PREFIX_WEIGHT + "91a"; // 'a' not allowed in weight

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditDayDescriptor DESC_1;
    public static final EditCommand.EditDayDescriptor DESC_2;

    static {
        DESC_1 = new EditDayDescriptorBuilder().withDate(VALID_DATE_1)
                .withWeight(VALID_WEIGHT_1).withEmail(VALID_EMAIL_1).withAddress(VALID_ADDRESS_1)
                .withTags(VALID_TAG_FRIEND).build();
        DESC_2 = new EditDayDescriptorBuilder().withDate(VALID_DATE_2)
                .withWeight(VALID_WEIGHT_2).withEmail(VALID_EMAIL_2).withAddress(VALID_ADDRESS_2)
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered day list and selected day in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Day> expectedFilteredList = new ArrayList<>(actualModel.getFilteredDayList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredDayList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the day at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showDayAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredDayList().size());

        Day day = model.getFilteredDayList().get(targetIndex.getZeroBased());
        final String[] splitDate = day.getDate().value.split("\\s+");
        model.updateFilteredDayList(new NameContainsKeywordsPredicate(Arrays.asList(splitDate[0])));

        assertEquals(1, model.getFilteredDayList().size());
    }

}
