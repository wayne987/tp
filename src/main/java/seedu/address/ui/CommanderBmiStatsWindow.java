package seedu.address.ui;

import java.util.logging.Logger;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * The controller for the commander overall BMI statistics window.
 */
public class CommanderBmiStatsWindow extends UiPart<Stage> {
    private static final Logger logger = LogsCenter.getLogger(CommanderBmiStatsWindow.class);
    private static final String FXML = "CommanderBmiStatsWindow.fxml";

    @FXML
    private PieChart pieChart;

    /**
     * Creates a new CommanderBmiStatsWindow.
     *
     * @param root Stage to use as the root of the CommanderBmiStatsWindow.
     */
    public CommanderBmiStatsWindow(Stage root) {
        super(FXML, root);
    }

    /**
     * Creates a new CommanderBmiStatsWindow.
     *
     * @param personList personList from seedu.address.logic.Logic
     */
    public CommanderBmiStatsWindow(ObservableList<Person> personList) {
        this(new Stage());

        pieChart.setTitle("Current Overall BMI Progress of Recruits");
        setBmiStats(personList);
    }

    private void setBmiStats(ObservableList<Person> personList) {
        assert personList != null;

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        int lessThan23 = 0;
        int lessThan27 = 0;
        int lessThan30 = 0;
        int moreThan30 = 0;

        for (Person p : personList) {
            if (p.getCurrentBmi() < 23) {
                lessThan23++;
            } else if (p.getCurrentBmi() < 27) {
                lessThan27++;
            } else if (p.getCurrentBmi() < 30) {
                lessThan30++;
            } else {
                moreThan30++;
            }
        }
        pieChartData.add(new PieChart.Data("< 23", lessThan23));
        pieChartData.add(new PieChart.Data("< 27", lessThan27));
        pieChartData.add(new PieChart.Data("< 30", lessThan30));
        pieChartData.add(new PieChart.Data("> 30", moreThan30));

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty(), " People"
                        )
                )
        );

        pieChart.setData(pieChartData);

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
        logger.fine("Showing weight statistics.");
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
