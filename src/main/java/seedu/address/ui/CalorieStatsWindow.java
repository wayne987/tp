package seedu.address.ui;

import java.util.Arrays;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.day.Day;

/**
 * The controller for the calorie statistics window.
 *
 * @@author Marco Jakob - Adapted
 * Adapted from https://code.makery.ch/library/javafx-tutorial/part6/
 * with modifications for this app context.
 */
public class CalorieStatsWindow extends UiPart<Stage> {

    private static final Logger logger = LogsCenter.getLogger(CalorieStatsWindow.class);
    private static final String FXML = "CalorieStatsWindow.fxml";

    @FXML
    private LineChart<String, Integer> lineChart;

    @FXML
    private CategoryAxis xAxis;

    private ObservableList<String> dates = FXCollections.observableArrayList();

    /**
     * Creates a new CalorieStatsWindow.
     *
     * @param root Stage to use as the root of the CalorieStatsWindow.
     */
    public CalorieStatsWindow(Stage root) {
        super(FXML, root);
    }

    /**
     * Creates a new CalorieStatsWindow.
     */
    public CalorieStatsWindow(ObservableList<Day> dayList) {
        this(new Stage());
        initialize(dayList);
        setCalorieData(dayList);
    }

    /**
     * Initializes the Line Chart
     */
    @FXML
    private void initialize(ObservableList<Day> dayList) {
        String[] datesString = dayList.stream().map(x -> x.getDate().get().toString())
                .toArray(String[]::new);

        dates.addAll(Arrays.asList(datesString));

        // Assign the dates as categories for the horizontal axis.
        xAxis.setCategories(dates);
    }

    /**
     * Sets the calorie data points to show the statistics for.
     *
     * @param dayList
     */
    public void setCalorieData(ObservableList<Day> dayList) {

        XYChart.Series<String, Integer> calorieIn = new XYChart.Series<>();
        XYChart.Series<String, Integer> calorieOut = new XYChart.Series<>();
        calorieIn.setName("Calorie In");
        calorieOut.setName("Calorie Out");

        //Get the calorie data of all the days.
        for (int i = 0; i < dayList.size(); i++) {
            calorieIn.getData()
                    .add(new XYChart.Data<>(dates.get(i), dayList.get(i).getTotalInputCalorie()));

            calorieOut.getData()
                    .add(new XYChart.Data<>(dates.get(i), dayList.get(i).getTotalOutputCalorie()));
        }

        lineChart.getData().add(calorieIn);
        lineChart.getData().add(calorieOut);
    }

    /**
     * Shows the weight statistics window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing calorie statistics.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }


}
