package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_WEIGHT;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.day.Day;

/**
 * Adds a day to the records.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a day to the records. "
            + "Parameters: "
            + PREFIX_DATE + "DATE "
            + PREFIX_WEIGHT + "WEIGHT "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DATE + "2020-10-14 "
            + PREFIX_WEIGHT + "70 ";

    public static final String MESSAGE_SUCCESS = "New day added: %1$s";
    public static final String MESSAGE_DUPLICATE_DAY = "This day already exists in the records.";

    private final Day toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Day}
     */
    public AddCommand(Day day) {
        requireNonNull(day);
        toAdd = day;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasDay(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_DAY);
        }
        if (model.isDefaultProfile()) { //no profile
            throw new CommandException(CreateCommand.MESSAGE_NO_PROFILE);
        }
        model.addDay(toAdd);
        model.updateDay();

        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
