package seedu.address.ui;

import javafx.fxml.FXML;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.model.day.calorie.Input;

public class CalorieInputListPanel extends UiPart<Region> {

    private static final String FXML = "CalorieInputListPanel.fxml";

    @FXML
    private ListView<Input> calorieInputListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public CalorieInputListPanel(ObservableList<Input> inputList) {
        super(FXML);
        calorieInputListView.setItems(inputList);
        calorieInputListView.setCellFactory(listView -> new CalorieInputListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
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
