package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CALORIE_TYPE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDEX;

import java.time.LocalDate;
import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.day.Day;
import seedu.address.model.day.calorie.Calorie;

public class RemoveCommand extends Command {

    public static final String COMMAND_WORD = "remove";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Removes the calorie identified by the index number and type used in the displayed day list.\n"
            + "Parameters:"
            + PREFIX_CALORIE_TYPE + "IN / OUT"
            + PREFIX_DATE + "Date"
            + PREFIX_INDEX + "Positive index number"
            + "Example: " + COMMAND_WORD + PREFIX_CALORIE_TYPE + " tp/out " + PREFIX_INDEX + " 1";

    public static final String MESSAGE_DELETE_CALORIE_SUCCESS = "Deleted Calorie + " + ": %1$s";

    private final Index targetIndex;

    private final String type;

    private final LocalDate date;

    /**
     * @param targetIndex of the calorie in the day to delete
     * @param type of the calorie to be deleted
     */
    public RemoveCommand(Index targetIndex, String type, LocalDate date) {
        this.targetIndex = targetIndex;
        this.type = type;
        this.date = date;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Day> lastShownList = model.getFilteredDayList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_DAY_DISPLAYED_INDEX);
        }

        List<Calorie> listOfCalorie;
        if (type.equals("OUT")) {
            listOfCalorie = model.getDay(date).getCalorieOutputList()
        }
        Day dayToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteDay(dayToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_CALORIE_SUCCESS, dayToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RemoveCommand // instanceof handles nulls
                && targetIndex.equals(((RemoveCommand) other).targetIndex) // state check
                && type.equals(((RemoveCommand) other).type));
    }
}
