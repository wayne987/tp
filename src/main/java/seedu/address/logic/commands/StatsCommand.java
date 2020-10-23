package seedu.address.logic.commands;

import static seedu.address.logic.parser.CliSyntax.PREFIX_VIEW_STATS;

import seedu.address.model.Model;

/**
 * Shows the respective statistics in a new window
 */
public class StatsCommand extends Command {

    public static final String COMMAND_WORD = "stats";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows the relevant statistics. \n"
            + "Options: " + COMMAND_WORD + " " + PREFIX_VIEW_STATS + "all \n"
            + COMMAND_WORD + " " + PREFIX_VIEW_STATS + "calorie \n"
            + COMMAND_WORD + " " + PREFIX_VIEW_STATS + "weight \n";

    public static final String SHOWING_ALL_STATS_MESSAGE = "Opened both stats window.";
    public static final String SHOWING_CALORIE_STATS_MESSAGE = "Opened calories stats window.";
    public static final String SHOWING_WEIGHT_STATS_MESSAGE = "Opened weight stats window.";

    private boolean showCalorie;
    private boolean showWeight;

    /**
     * @param showCalorie to show the calorie statistics
     * @param showWeight to show the weight statistics
     */
    public StatsCommand(boolean showCalorie, boolean showWeight) {
        this.showCalorie = showCalorie;
        this.showWeight = showWeight;
    }

    @Override
    public CommandResult execute (Model model) {
        if (showCalorie && !showWeight) { /* Show calorie statistics only*/
            return new CommandResult(SHOWING_CALORIE_STATS_MESSAGE, false, false, false, true, false);
        } else if (!showCalorie && showWeight) { /* Show weight statistics only*/
            return new CommandResult(SHOWING_WEIGHT_STATS_MESSAGE, false, false, false, false, true);
        } else { /* Show both statistics */
            return new CommandResult(SHOWING_ALL_STATS_MESSAGE, false, false, true, false, false);
        }
    }
}
