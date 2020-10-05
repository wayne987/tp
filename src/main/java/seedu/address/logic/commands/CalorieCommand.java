package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.calorie.Calorie;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

public class CalorieCommand extends Command{

    public static final String COMMAND_WORD = "calorie";
    private Calorie calorie;
    public CalorieCommand(Calorie calorie){
        this.calorie = calorie;
    }

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(calorie.toString());
    }

}
