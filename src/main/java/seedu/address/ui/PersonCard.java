package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.model.person.Profile;

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

    public final Person person;
    private MainWindow mainWindow;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label fourD;
    @FXML
    private Label height;
    @FXML
    private Label weight;



    /**
     * Creates a {@code DayCard} with the given {@code Day} and index to display and the given {@code MainWindow}.
     */
    public PersonCard(Person person, int displayedIndex, MainWindow mainWindow) {
        super(FXML);
        System.out.println(person);
        this.person = person;
        Profile profile = person.getProfile();
        id.setText(displayedIndex + ". ");
        name.setText("Name: " + profile.getName().fullName);
        fourD.setText("ID: " + profile.getId().value);
        height.setText("Height: " + profile.getHeight().value);
        weight.setText("Weight: " + profile.getTargetWeight().value + " kg");
        this.mainWindow = mainWindow;

        // Fills the calorie placeholders when a DayCard is double clicked
        cardPane.setOnMouseClicked(x -> displayCalories(displayedIndex - 1));
    }

    /**
     * Displays the list of calorie inputs and outputs.
     *
     * @param index the index of the day that was clicked.
     */
    private void displayCalories(int index) {
        this.mainWindow.fillCaloriePanels(index);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DayCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }
}
