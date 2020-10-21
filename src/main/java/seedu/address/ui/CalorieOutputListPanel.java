package seedu.address.ui;

import javafx.fxml.FXML;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.model.day.calorie.Output;

public class CalorieOutputListPanel extends UiPart<Region> {

    private static final String FXML = "CalorieOutputListPanel.fxml";

    @FXML
    private ListView<Output> calorieOutputListView;

    /**
     * Creates a {@code CalorieOutputListPanel} with the given {@code ObservableList}.
     */
    public CalorieOutputListPanel(ObservableList<Output> outputList) {
        super(FXML);
        calorieOutputListView.setItems(outputList);
        calorieOutputListView.setCellFactory(listView -> new CalorieOutputListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Output} using a {@code CalorieOutputCard}.
     */
    class CalorieOutputListViewCell extends ListCell<Output> {
        @Override
        protected void updateItem(Output calorieOutput, boolean empty) {
            super.updateItem(calorieOutput, empty);

            if (empty || calorieOutput == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new CalorieOutputCard(calorieOutput, getIndex() + 1).getRoot());
            }
        }
    }

}
