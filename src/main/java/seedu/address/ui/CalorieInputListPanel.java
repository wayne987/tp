package seedu.address.ui;

import java.util.ArrayList;

import javafx.fxml.FXML;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.model.day.calorie.Input;

/**
 * Panel containing a list of Inputs.
 */
public class CalorieInputListPanel extends UiPart<Region> {

    private static final String FXML = "CalorieInputListPanel.fxml";

    @FXML
    private ListView<Input> calorieInputListView;

    public CalorieInputListPanel() {
        super(FXML);
    }
    /**
     * Creates a {@code CalorieInputListPanel} with the given {@code ObservableList}.
     */
    public CalorieInputListPanel(ObservableList<Input> inputList) {
        super(FXML);
        assert inputList != null;
        calorieInputListView.setItems(inputList);
        calorieInputListView.setCellFactory(listView -> new CalorieInputListViewCell());
    }

    public void update(ObservableList<Input> inputList) {
        calorieInputListView.setItems(inputList);
        calorieInputListView.setCellFactory(listView -> new CalorieInputListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Input} using a {@code CalorieInputCard}.
     */
    class CalorieInputListViewCell extends ListCell<Input> {
        @Override
        protected void updateItem(Input calorieInput, boolean empty) {
            super.updateItem(calorieInput, empty);

            if (empty || calorieInput == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new CalorieInputCard(calorieInput, getIndex() + 1).getRoot());
            }
        }
    }

}
