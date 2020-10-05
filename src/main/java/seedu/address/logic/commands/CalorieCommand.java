package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.person.calorie.Calorie;


public class CalorieCommand extends Command {

    public static final String COMMAND_WORD = "calorie";
    private Calorie calorie;
    public CalorieCommand(Calorie calorie) {
        this.calorie = calorie;
    }

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(calorie.toString());
    }

}
