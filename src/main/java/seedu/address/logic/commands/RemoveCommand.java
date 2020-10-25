package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.commands.CalorieCommand.NO_AVAILABLE_DAY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CALORIE_TYPE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDEX;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_DAYS;

import java.time.LocalDate;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.calorie.Calorie;
import seedu.address.model.calorie.CalorieManager;
import seedu.address.model.day.Day;

/**
 * Removes a certain calorie input/output from a particular day
 */
public class RemoveCommand extends Command {

    public static final String COMMAND_WORD = "remove";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Removes the calorie identified by the index number and type used in the displayed day list.\n"
            + "Parameters:"
            + PREFIX_CALORIE_TYPE + "IN / OUT"
            + PREFIX_DATE + "Date"
            + PREFIX_INDEX + "Positive index number"
            + "Example: " + COMMAND_WORD + PREFIX_CALORIE_TYPE + " tp/out " + PREFIX_INDEX + " 1";

    public static final String MESSAGE_DELETE_CALORIE_SUCCESS = "Removed Calorie - " + ": %1$s";

    private final Index targetIndex;

    private final Boolean isOut;

    private final LocalDate date;

    /**
     * @param targetIndex of the calorie in the day to delete
     * @param isOut if the calorie is Output calorie
     * @param date of the day that the calorie belongs to
     */
    public RemoveCommand(Index targetIndex, Boolean isOut, LocalDate date) {
        this.targetIndex = targetIndex;
        this.isOut = isOut;
        this.date = date;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasDay(date)) {
            throw new CommandException(NO_AVAILABLE_DAY);
        }

        Day editDay = model.getDay(date);
        CalorieManager calorieManager = editDay.getCalorieManager();

        if (targetIndex.getZeroBased() >= calorieManager.getListSize(isOut)) {
            throw new CommandException(Messages.MESSAGE_INVALID_DAY_DISPLAYED_INDEX);
        }

        Calorie remove = calorieManager.getCalorie(isOut, targetIndex);
        editDay.getCalorieManager().removeCalorie(isOut, targetIndex);

        model.setDay(model.getDay(date), editDay);
        model.updateFilteredDayList(PREDICATE_SHOW_ALL_DAYS);
        return new CommandResult(String.format(MESSAGE_DELETE_CALORIE_SUCCESS, remove));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof RemoveCommand // instanceof handles nulls
                && targetIndex.equals(((RemoveCommand) other).targetIndex) // state check
                && isOut.equals(((RemoveCommand) other).isOut));
    }
}
