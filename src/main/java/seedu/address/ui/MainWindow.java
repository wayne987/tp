package seedu.address.ui;

import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class MainWindow extends UiPart<Stage> {

    private static final String FXML = "MainWindow.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private Stage primaryStage;
    private Logic logic;

    // Independent Ui parts residing in this Ui container
    private DayListPanel dayListPanel;
    private CalorieInputListPanel calorieInputListPanel;
    private CalorieOutputListPanel calorieOutputListPanel;
    private ResultDisplay resultDisplay;
    private HelpWindow helpWindow;
    private WeightStatsWindow weightStatsWindow;
    private CalorieStatsWindow calorieStatsWindow;
    private StatusBarDaySelected statusBarDaySelected;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private MenuItem helpMenuItem;

    @FXML
    private StackPane statusbarDaySelectedPlaceholder;

    private StackPane dayListPanelPlaceholder;

    @FXML
    private StackPane calorieInputListPanelPlaceholder;

    @FXML
    private StackPane calorieOutputListPanelPlaceholder;

    @FXML
    private StackPane resultDisplayPlaceholder;

    @FXML
    private StackPane statusBarPlaceholder;

    @FXML
    private MenuItem weightStatsMenuItem;

    @FXML
    private MenuItem calorieStatsMenuItem;

    @FXML
    private MenuItem allStatsMenuItem;

    /**
     * Creates a {@code MainWindow} with the given {@code Stage} and {@code Logic}.
     */
    public MainWindow(Stage primaryStage, Logic logic) {
        super(FXML, primaryStage);

        // Set dependencies
        this.primaryStage = primaryStage;
        this.logic = logic;

        // Configure the UI
        setWindowDefaultSize(logic.getGuiSettings());

        setAccelerators();

        helpWindow = new HelpWindow();

        weightStatsWindow = new WeightStatsWindow(logic.getFilteredDayList());

        calorieStatsWindow = new CalorieStatsWindow(logic.getFilteredDayList());
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private void setAccelerators() {
        setAccelerator(helpMenuItem, KeyCombination.valueOf("F1"));
    }

    /**
     * Sets the accelerator of a MenuItem.
     * @param keyCombination the KeyCombination value of the accelerator
     */
    private void setAccelerator(MenuItem menuItem, KeyCombination keyCombination) {
        menuItem.setAccelerator(keyCombination);

        /*
         * TODO: the code below can be removed once the bug reported here
         * https://bugs.openjdk.java.net/browse/JDK-8131666
         * is fixed in later version of SDK.
         *
         * According to the bug report, TextInputControl (TextField, TextArea) will
         * consume function-key events. Because CommandBox contains a TextField, and
         * ResultDisplay contains a TextArea, thus some accelerators (e.g F1) will
         * not work when the focus is in them because the key event is consumed by
         * the TextInputControl(s).
         *
         * For now, we add following event filter to capture such key events and open
         * help window purposely so to support accelerators even when focus is
         * in CommandBox or ResultDisplay.
         */
        getRoot().addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getTarget() instanceof TextInputControl && keyCombination.match(event)) {
                menuItem.getOnAction().handle(new ActionEvent());
                event.consume();
            }
        });
    }

    /**
     * Updates the calorie panels with calorie values of the day that is clicked.
     *
     * @param index the index of the day that is clicked
     */
    void updateCaloriePanels(int index) {
        // first i need to check if the current calorie lists that are showing is the one being deleted.
        boolean isLastDayInList = index == logic.getFilteredDayList().size();
        if (isLastDayInList) {
            clearCaloriePanels();
        } else {
            calorieInputListPanel.update(logic.getFilteredDayList().get(index).getCalorieManager()
                    .getCalorieInputList());
            calorieOutputListPanel.update(logic.getFilteredDayList().get(index).getCalorieManager()
                    .getCalorieOutputList());
        }
    }

    void clearCaloriePanels() {
        calorieInputListPanel.clear();
        calorieOutputListPanel.clear();
    }

    void setDateLabel(String date) {
        statusBarDaySelected.setDateSelectedLabel(date);
    }

    void updateDateLabel(int index) {
        boolean isLastDayInList = index == logic.getFilteredDayList().size();
        if (isLastDayInList) {
            clearDateLabel();
        } else {
            String dateStringOfNextDay = logic.getFilteredDayList().get(index).getDate().get().toString();
            setDateLabel(dateStringOfNextDay);
        }
    }

    void clearDateLabel() {
        statusBarDaySelected.clear();
    }

    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {
        statusBarDaySelected = new StatusBarDaySelected();
        statusbarDaySelectedPlaceholder.getChildren().add(statusBarDaySelected.getRoot());

        dayListPanel = new DayListPanel(logic.getFilteredDayList(), this);
        dayListPanelPlaceholder.getChildren().add(dayListPanel.getRoot());

        calorieInputListPanel = new CalorieInputListPanel();
        calorieInputListPanelPlaceholder.getChildren().add(calorieInputListPanel.getRoot());
        calorieOutputListPanel = new CalorieOutputListPanel();
        calorieOutputListPanelPlaceholder.getChildren().add(calorieOutputListPanel.getRoot());

        resultDisplay = new ResultDisplay();
        resultDisplayPlaceholder.getChildren().add(resultDisplay.getRoot());

        StatusBarFooter statusBarFooter = new StatusBarFooter(logic.getMyFitnessBuddyFilePath());
        statusBarPlaceholder.getChildren().add(statusBarFooter.getRoot());

        CommandBox commandBox = new CommandBox(this::executeCommand);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());
    }

    /**
     * Sets the default size based on {@code guiSettings}.
     */
    private void setWindowDefaultSize(GuiSettings guiSettings) {
        primaryStage.setHeight(guiSettings.getWindowHeight());
        primaryStage.setWidth(guiSettings.getWindowWidth());
        if (guiSettings.getWindowCoordinates() != null) {
            primaryStage.setX(guiSettings.getWindowCoordinates().getX());
            primaryStage.setY(guiSettings.getWindowCoordinates().getY());
        }
    }

    /**
     * Opens the help window or focuses on it if it's already opened.
     */
    @FXML
    public void handleHelp() {
        if (!helpWindow.isShowing()) {
            helpWindow.show();
        } else {
            helpWindow.focus();
        }
    }

    /**
     * Opens the weight stats window or focuses on it if it's already opened.
     */
    @FXML
    public void handleWeightStats() {
        if (!weightStatsWindow.isShowing()) {
            weightStatsWindow.show();
        } else {
            weightStatsWindow.focus();
        }
    }

    /**
     * Opens the calorie stats window or focuses on it if it's already opened.
     */
    @FXML
    public void handleCalorieStats() {
        if (!calorieStatsWindow.isShowing() && !weightStatsWindow.isShowing()) {
            calorieStatsWindow.show();
        } else if (!calorieStatsWindow.isShowing() && weightStatsWindow.isShowing()) {
            calorieStatsWindow.show();
            //prevent both windows stacking over each other when opened at the same time
            calorieStatsWindow.getRoot().setY(weightStatsWindow.getRoot().getY() + 100);
        } else {
            calorieStatsWindow.focus();
        }
    }

    /**
     * Opens both stats window or focuses on it if it's already opened.
     */
    public void handleAllStats() {
        handleWeightStats();
        handleCalorieStats();
    }

    /**
     * Removes the items shown in the calorie lists if any.
     */
    @FXML
    public void handleClear() {
        clearCaloriePanels();
        clearDateLabel();
    }

    /**
     * Removes the items shown in the calorie lists if the day being shown is deleted.
     *
     * @param index index of the item that is deleted.
     */
    @FXML
    public void handleDelete(int index) {
        updateCaloriePanels(index - 1);
        updateDateLabel(index - 1);
    }

    void show() {
        primaryStage.show();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        GuiSettings guiSettings = new GuiSettings(primaryStage.getWidth(), primaryStage.getHeight(),
                (int) primaryStage.getX(), (int) primaryStage.getY());
        System.out.println(primaryStage.getHeight());
        logic.setGuiSettings(guiSettings);
        helpWindow.hide();
        weightStatsWindow.hide();
        calorieStatsWindow.hide();
        primaryStage.hide();
    }

    public DayListPanel getDayListPanel() {
        return dayListPanel;
    }

    /**
     * Executes the command and returns the result.
     *
     * @see seedu.address.logic.Logic#execute(String)
     */
    private CommandResult executeCommand(String commandText) throws CommandException, ParseException {
        try {
            CommandResult commandResult = logic.execute(commandText);
            logger.info("Result: " + commandResult.getFeedbackToUser());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

            if (commandResult.isShowHelp()) {
                handleHelp();
            }

            if (commandResult.isExit()) {
                handleExit();
            }

            if (commandResult.isShowAllStats()) {
                handleAllStats();
            }

            if (commandResult.isShowCalorieStats()) {
                handleCalorieStats();
            }

            if (commandResult.isShowWeightStats()) {
                handleWeightStats();
            }

            if (commandResult.isClear()) {
                handleClear();
            }

            if (commandResult.isDelete()) {
                handleDelete(commandResult.getIndex());
            }

            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }
}
