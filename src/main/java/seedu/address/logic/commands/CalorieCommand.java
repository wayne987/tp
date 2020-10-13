package seedu.address.logic.commands;


import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.day.calorie.Calorie;
import seedu.address.model.day.calorie.Input;
import seedu.address.model.day.calorie.Output;

public class CalorieCommand extends Command {

    public static final String COMMAND_WORD = "calorie";
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
        if (model.hasDay()) {
            if (type.equals("in")) {
                model.getDay().addCalorieInput((Input) calorie);
            } else {
                model.getDay().addCalorieOutput((Output) calorie);
            }
        } else {
            throw new CommandException("please add a new entry for today before adding calorie input/output");
        }
        return new CommandResult(calorie.toString());
    }
}
