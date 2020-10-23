package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.StatsCommand.SHOWING_ALL_STATS_MESSAGE;
import static seedu.address.logic.commands.StatsCommand.SHOWING_CALORIE_STATS_MESSAGE;
import static seedu.address.logic.commands.StatsCommand.SHOWING_WEIGHT_STATS_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class StatsCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_viewBothStats_success() {
        CommandResult expectedCommandResult =
                new CommandResult(SHOWING_ALL_STATS_MESSAGE, false, false, true, false, false);
        assertCommandSuccess(new StatsCommand(true, true), model,
                expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_viewCalorieStats_success() {
        CommandResult expectedCommandResult =
                new CommandResult(SHOWING_CALORIE_STATS_MESSAGE, false, false, false, true, false);
        assertCommandSuccess(new StatsCommand(true, false), model,
                expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_viewWeightStats_success() {
        CommandResult expectedCommandResult =
                new CommandResult(SHOWING_WEIGHT_STATS_MESSAGE, false, false, false, false, true);
        assertCommandSuccess(new StatsCommand(false, true), model,
                expectedCommandResult, expectedModel);
    }

}
