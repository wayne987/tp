package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.day.Day;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Day day;

    @FXML
    private HBox cardPane;
    @FXML
    private Label date;
    @FXML
    private Label id;
    @FXML
    private Label weight;
    @FXML
    private Label totalCalorieIn;
    @FXML
    private Label totalCalorieOut;
//    @FXML
//    private FlowPane tags;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Day day, int displayedIndex) {
        super(FXML);
        this.day = day;
        id.setText(displayedIndex + ". ");
        date.setText(day.getName().fullName);
        weight.setText(day.getWeight().value + " kg");
        totalCalorieIn.setText("Total Calories In: " + day.getAddress().value + " calories");
        totalCalorieOut.setText("Total Calories Out: " + day.getEmail().value +  " calories");
//        day.getTags().stream()
//                .sorted(Comparator.comparing(tag -> tag.tagName))
//                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
                && day.equals(card.day);
    }
}
