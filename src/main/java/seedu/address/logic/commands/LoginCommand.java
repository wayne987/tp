package seedu.address.logic.commands;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;


public class LoginCommand extends Command {

    public static final String COMMAND_WORD = "login";
    private final int i;

    public LoginCommand(Index i) {
        this.i = i.getZeroBased();
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {

        List<Person> ul = model.getMyFitnessBuddy().getPersons();
        if (ul.size() <= i || ul.size() == 0) {
            throw new CommandException("not valid index");
        }
        Person toChange = ul.get(i);
        model.setCurrentPerson(toChange);
        model.updateDay();

        return new CommandResult(toChange.toString());
    }
}
