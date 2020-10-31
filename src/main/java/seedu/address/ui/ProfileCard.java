package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import seedu.address.model.person.Person;
import seedu.address.model.person.Profile;

/**
 * An UI component that displays information of a {@code Profile} from given {@code Person}.
 */
public class ProfileCard extends UiPart<Region> {

    //displayed Index fx:id is renamed -> fx:id=index to remove ambiguity with id of Profile
    private static final String FXML = "ProfileListCard.fxml";

    private static final double LENGTH = 200;

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
    @FXML
    private ImageView profilePicture;
    @FXML
    private Image user = new Image(this.getClass()
            .getResourceAsStream("/images/ProfilePicture/" + "1111" + ".png"));
    @FXML
    private Image def = new Image(this.getClass().getResourceAsStream("/images/User.png"));

    /**
     * Creates a {@code ProfileCard} with the given {@code Person} and index to display.
     */
    public ProfileCard(Person person, int displayedIndex) {
        super(FXML);
        this.profile = person.getProfile();
        index.setText(displayedIndex + ". ");
        name.setText("Name: " + profile.getName().toString());
        id.setText("ID: " + profile.getId().toString());
        targetWeight.setText("Target Weight: " + profile.getTargetWeight().toString());
        height.setText("Height: " + profile.getHeight().toString());
        String path = "/images/ProfilePicture/" + profile.getId().toString() + ".png";
        try {
            user = new Image(this.getClass().getResourceAsStream(path));
        } catch (NullPointerException e) {
            user = def;
        }
        profilePicture.setImage(user);
        circleClip(profilePicture);
    }

    /**
     * Creates a {@code ProfileCard} with the given {@code Person}.
     * To display the current loaded profile.
     */
    public ProfileCard(Person person) {
        super(FXML);
        this.profile = person.getProfile();
        index.setText("");
        name.setText("Name: " + profile.getName().toString());
        name.setTranslateX(-5);
        id.setText("ID: " + profile.getId().toString());
        targetWeight.setText("Target Weight: " + profile.getTargetWeight().toString());
        height.setText("Height: " + profile.getHeight().toString());
        String path = "/images/ProfilePicture/" + profile.getId().toString() + ".png";
        try {
            user = new Image(this.getClass().getResourceAsStream(path));
        } catch (NullPointerException e) {
            user = def;
        }
        profilePicture.setImage(user);
        circleClip(profilePicture);
    }

    /**
     * Clips the image into a circle
     */
    private void circleClip(ImageView imageView) {
        Circle clip = new Circle(imageView.getFitWidth());
        clip.setCenterX(0.5);
        clip.setCenterY(0.5);
        clip.setRadius(0.5);
        imageView.setClip(clip);
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
