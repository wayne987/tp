package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    /** Statistics should be shown to the user */
    private final boolean showAllStats;
    private final boolean showCalorieStats;
    private final boolean showWeightStats;

    private final boolean clear;
    private final boolean delete;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit,
                         boolean showAllStats, boolean showCalorieStats, boolean showWeightStats, boolean clear, boolean delete) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.showAllStats = showAllStats;
        this.showCalorieStats = showCalorieStats;
        this.showWeightStats = showWeightStats;
        this.clear = clear;
        this.delete = delete;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false, false, false, false, false, false);
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser, showAllStats, showCalorieStats,
     * showWeightStats},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser, boolean showAllStats, boolean showCalorieStats,
                         boolean showWeightStats) {
        this(feedbackToUser, false, false, showAllStats, showCalorieStats, showWeightStats, false, false);
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser, showHelp, exit},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, boolean clear, boolean delete) {
        this(feedbackToUser, showHelp, exit, false, false, false, clear, delete);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isShowAllStats() {
        return showAllStats;
    }

    public boolean isShowCalorieStats() {
        return showCalorieStats;
    }

    public boolean isShowWeightStats() {
        return showWeightStats;
    }

    public boolean isClear() {
        return clear;
    }

    public boolean isDelete() {
        return delete;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit
                && showAllStats == otherCommandResult.showAllStats
                && showCalorieStats == otherCommandResult.showCalorieStats
                && showWeightStats == otherCommandResult.showWeightStats;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit, showAllStats, showCalorieStats, showWeightStats);
    }

}
