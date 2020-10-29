package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.CalorieCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.calorie.Input;
import seedu.address.model.calorie.Output;
import seedu.address.model.calorie.Time;
import seedu.address.testutil.CalorieBuilder;



public class CalorieCommandParserTest {
    private CalorieCommandParser parser = new CalorieCommandParser();

    @Test
    public void parse_allFieldsPresent_success() throws ParseException {
        Output calorie = new CalorieBuilder().withTime("1234")
                                             .withExercise("running")
                                             .withCalorieCount("1234")
                                             .buildOutput();

        Input calorie2 = new CalorieBuilder().withTime("1234")
                                            .withFood("laksa")
                                            .withCalorieCount("1234")
                                            .buildInput();

        String date = LocalDate.now().toString();
        // whitespace only preamble
        assertParseSuccess(parser, "    d/2020-10-10 tp/out t/1234 e/running c/1234",
                new CalorieCommand(calorie, true, "2020-10-10"));

        // no date - current date
        assertParseSuccess(parser, " tp/in t/1234 f/laksa c/1234",
                new CalorieCommand(calorie2, false, date));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, CalorieCommand.MESSAGE_USAGE);

        // missing type prefix
        assertParseFailure(parser, "e/running c/1234",
                expectedMessage);

        // missing activity prefix
        assertParseFailure(parser, "tp/out c/1234",
                expectedMessage);

        // missing calorie count prefix
        assertParseFailure(parser, "tp/out e/running",
                expectedMessage);

        // double field
        assertParseFailure(parser, "tp/out e/running f/asdf c/123 t/1234",
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {

        // wrong type value
        assertParseFailure(parser, " tp/asdf t/1234 e/running c/123",
                "type can only be either in/out");

        // wrong type value
        assertParseFailure(parser, " tp/out t/123 e/running c/123",
                Time.MESSAGE_CONSTRAINTS);

        // wrong activity prefix
        assertParseFailure(parser, " tp/out t/1230 f/laksa c/123",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, CalorieCommand.MESSAGE_USAGE));

        // wrong activity prefix
        assertParseFailure(parser, " tp/out t/1230 f/running c/123",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, CalorieCommand.MESSAGE_USAGE));

    }
}
