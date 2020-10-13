package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_1;
import static seedu.address.logic.commands.CommandTestUtil.ADDRESS_DESC_2;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_1;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_2;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_1;
import static seedu.address.logic.commands.CommandTestUtil.EMAIL_DESC_2;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_ADDRESS_DESC;
//import static seedu.address.logic.commands.CommandTestUtil.INVALID_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EMAIL_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_WEIGHT_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WEIGHT_2;
import static seedu.address.logic.commands.CommandTestUtil.WEIGHT_DESC_1;
import static seedu.address.logic.commands.CommandTestUtil.WEIGHT_DESC_2;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalDays.AMY;
import static seedu.address.testutil.TypicalDays.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.AddCommand;
import seedu.address.model.day.Address;
//import seedu.address.model.day.Date;
import seedu.address.model.day.Day;
import seedu.address.model.day.Email;
import seedu.address.model.day.Weight;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.DayBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Day expectedDay = new DayBuilder(BOB).withTags(VALID_TAG_FRIEND).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + DATE_DESC_2 + WEIGHT_DESC_2 + EMAIL_DESC_2
                + ADDRESS_DESC_2 + TAG_DESC_FRIEND, new AddCommand(expectedDay));

        // multiple dates - last date accepted
        assertParseSuccess(parser, DATE_DESC_1 + DATE_DESC_2 + WEIGHT_DESC_2 + EMAIL_DESC_2
                + ADDRESS_DESC_2 + TAG_DESC_FRIEND, new AddCommand(expectedDay));

        // multiple weights - last weight accepted
        assertParseSuccess(parser, DATE_DESC_2 + WEIGHT_DESC_1 + WEIGHT_DESC_2 + EMAIL_DESC_2
                + ADDRESS_DESC_2 + TAG_DESC_FRIEND, new AddCommand(expectedDay));

        // multiple emails - last email accepted
        assertParseSuccess(parser, DATE_DESC_2 + WEIGHT_DESC_2 + EMAIL_DESC_1 + EMAIL_DESC_2
                + ADDRESS_DESC_2 + TAG_DESC_FRIEND, new AddCommand(expectedDay));

        // multiple addresses - last address accepted
        assertParseSuccess(parser, DATE_DESC_2 + WEIGHT_DESC_2 + EMAIL_DESC_2 + ADDRESS_DESC_1
                + ADDRESS_DESC_2 + TAG_DESC_FRIEND, new AddCommand(expectedDay));

        // multiple tags - all accepted
        Day expectedDayMultipleTags = new DayBuilder(BOB).withTags(VALID_TAG_FRIEND, VALID_TAG_HUSBAND)
                .build();
        assertParseSuccess(parser, DATE_DESC_2 + WEIGHT_DESC_2 + EMAIL_DESC_2 + ADDRESS_DESC_2
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, new AddCommand(expectedDayMultipleTags));
    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        // zero tags
        Day expectedDay = new DayBuilder(AMY).withTags().build();
        assertParseSuccess(parser, DATE_DESC_1 + WEIGHT_DESC_1 + EMAIL_DESC_1 + ADDRESS_DESC_1,
                new AddCommand(expectedDay));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing date prefix
        assertParseFailure(parser, VALID_DATE_2 + WEIGHT_DESC_2 + EMAIL_DESC_2 + ADDRESS_DESC_2,
                expectedMessage);

        // missing weight prefix
        assertParseFailure(parser, DATE_DESC_2 + VALID_WEIGHT_2 + EMAIL_DESC_2 + ADDRESS_DESC_2,
                expectedMessage);

        // missing email prefix
        assertParseFailure(parser, DATE_DESC_2 + WEIGHT_DESC_2 + VALID_EMAIL_2 + ADDRESS_DESC_2,
                expectedMessage);

        // missing address prefix
        assertParseFailure(parser, DATE_DESC_2 + WEIGHT_DESC_2 + EMAIL_DESC_2 + VALID_ADDRESS_2,
                expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_DATE_2 + VALID_WEIGHT_2 + VALID_EMAIL_2 + VALID_ADDRESS_2,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid date
        //        assertParseFailure(parser, INVALID_DATE_DESC + WEIGHT_DESC_2 + EMAIL_DESC_2 + ADDRESS_DESC_2
        //                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Date.MESSAGE_CONSTRAINTS);

        // invalid weight
        assertParseFailure(parser, DATE_DESC_2 + INVALID_WEIGHT_DESC + EMAIL_DESC_2 + ADDRESS_DESC_2
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Weight.MESSAGE_CONSTRAINTS);

        // invalid email
        assertParseFailure(parser, DATE_DESC_2 + WEIGHT_DESC_2 + INVALID_EMAIL_DESC + ADDRESS_DESC_2
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Email.MESSAGE_CONSTRAINTS);

        // invalid address
        assertParseFailure(parser, DATE_DESC_2 + WEIGHT_DESC_2 + EMAIL_DESC_2 + INVALID_ADDRESS_DESC
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Address.MESSAGE_CONSTRAINTS);

        // invalid tag
        assertParseFailure(parser, DATE_DESC_2 + WEIGHT_DESC_2 + EMAIL_DESC_2 + ADDRESS_DESC_2
                + INVALID_TAG_DESC + VALID_TAG_FRIEND, Tag.MESSAGE_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        //        assertParseFailure(parser, INVALID_DATE_DESC + WEIGHT_DESC_2 + EMAIL_DESC_2 + INVALID_ADDRESS_DESC,
        //                Date.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + DATE_DESC_2 + WEIGHT_DESC_2 + EMAIL_DESC_2
                + ADDRESS_DESC_2 + TAG_DESC_HUSBAND + TAG_DESC_FRIEND,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }
}
