package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;
import seedu.address.model.person.Profile;

/**
 * An UI component that displays information of a {@code Profile} from given {@code Person}.
 */
public class ProfileCard extends UiPart<Region> {

    //displayed Index fx:id is renamed -> fx:id=index to remove ambiguity with id of Profile
    private static final String FXML = "ProfileListCard.fxml";

    public final Profile profile;


    @FXML
    private HBox cardPane;
    @FXML
    private Label index;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label targetWeight;
    @FXML
    private Label height;

    /**
     * Creates a {@code ProfileCard} with the given {@code Person} and index to display.
     */
    public ProfileCard(Person person, int displayedIndex) {
        super(FXML);
        this.profile = person.getProfile();
        index.setText(displayedIndex + ".");
        name.setText("Name: " + profile.getName().toString());
        id.setText("ID: " + profile.getId().toString());
        targetWeight.setText("Target Weight: " + profile.getTargetWeight().toString());
        height.setText("Height: " + profile.getHeight().toString());
    }

    public ProfileCard(Person person) {
        super(FXML);
        this.profile = person.getProfile();
        index.setText("");
        name.setText("Name: " + profile.getName().toString());
        id.setText("ID: " + profile.getId().toString());
        targetWeight.setText("Target Weight: " + profile.getTargetWeight().toString());
        height.setText("Height: " + profile.getHeight().toString());
    }

    @Override
    public boolean equals(Object other) {
        //short circuit if same object
        if (other == this) {
            return true;
        }

        //instanceof handles nulls
        if (!(other instanceof ProfileCard)) {
            return false;
        }

        //state check
        ProfileCard card = (ProfileCard) other;
        return index.getText().equals(card.index.getText())
                && profile.equals(card.profile);
    }
}
