package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_CALORIE_COUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CALORIE_TYPE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXERCISE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FOOD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_DAYS;

import java.time.LocalDate;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.day.Day;
import seedu.address.model.day.calorie.Calorie;
import seedu.address.model.day.calorie.Input;
import seedu.address.model.day.calorie.Output;




public class CalorieCommand extends Command {

    public static final String COMMAND_WORD = "calorie";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a calorie to the records. "
            + "Parameters: "
            + PREFIX_CALORIE_TYPE + "TYPE(in/out) "
            + PREFIX_TIME + "TIME "
            + PREFIX_FOOD + "FOOD(in) or "
            + PREFIX_EXERCISE + "EXERCISE(out) "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_CALORIE_TYPE + "in "
            + PREFIX_TIME + "2100 "
            + PREFIX_FOOD + "Laksa "
            + PREFIX_CALORIE_COUNT + "400";

    private Calorie calorie;
    private String type;

    /**
     * Creates an CalorieCommand to add the specified {@code Calorie}
     */
    public CalorieCommand(Calorie calorie, String type) {
        this.calorie = calorie;
        this.type = type;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        LocalDate date = LocalDate.now();
        if (model.hasDay(date)) {
            Day editDay = model.getDay();
            if (type.equals("in")) {
                editDay.addCalorieInput((Input) calorie);
            } else {
                editDay.addCalorieOutput((Output) calorie);
            }
            model.setDay(model.getDay(), editDay);
            model.updateFilteredDayList(PREDICATE_SHOW_ALL_DAYS);
        } else {
            throw new CommandException("please add a new entry for today before adding calorie input/output");
        }
        return new CommandResult(calorie.toString());
    }
}
