package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the current loaded Profile.
 */
public class ProfileCardPanel extends UiPart<Region> {

    public static final String FXML = "ProfileCardPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ProfileCardPanel.class);

    @FXML
    private ListView<Person> profileCardView;

    /**
     * Creates a {@code ProfileCardPanel} with the given {@code Person}.
     */
    public ProfileCardPanel(Person person) {
        super(FXML);
        ObservableList<Person> list = FXCollections.observableArrayList();
        list.add(person);
        profileCardView.setItems(list);
        profileCardView.setCellFactory(listView -> new ProfileCardViewCell());
        logger.info("ProfileCardPanel created");
    }

    /**
     * Clears the current profile panel.
     */
    public void clear() {
        profileCardView.setItems(FXCollections.observableArrayList());
        profileCardView.setCellFactory(listView -> new ProfileCardViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Input} using a {@code CalorieInputCard}.
     */
    class ProfileCardViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new ProfileCard(person).getRoot());
            }
        }
    }
}
