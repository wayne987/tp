package seedu.address.logic.parser;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.LoginCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class LoginCommandParser implements Parser<LoginCommand> {


    @Override
    public LoginCommand parse(String userInput) throws ParseException {

        Index index = ParserUtil.parseIndex(userInput);
        return new LoginCommand(index);
    }
}
