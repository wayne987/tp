package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.day.Date;
import seedu.address.model.day.Day;
import seedu.address.model.day.Weight;
import seedu.address.model.person.Height;
import seedu.address.model.person.ID;
import seedu.address.model.person.Name;
import seedu.address.model.person.Profile;



/**
 * Jackson-friendly version of {@link Day}.
 */
class JsonAdaptedProfile {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Profile's %s field is missing!";
    private final String name;
    private final String id;
    private final String height;
    private final String targetWeight;


    /**
     * Constructs a {@code JsonAdaptedDay} with the given day details.
     */
    @JsonCreator
    public JsonAdaptedProfile(@JsonProperty("name") String name, @JsonProperty("id") String id,
                          @JsonProperty("height") String height, @JsonProperty("targetWeight") String targetWeight) {
        this.name = name;
        this.id = id;
        this.height = height;
        this.targetWeight = targetWeight;
    }

    /**
     * Converts a given {@code Date} into this class for Jackson use.
     */
    public JsonAdaptedProfile(Profile source) {
        name = source.getName().fullName;
        id = source.getId().value;
        height = source.getHeight().value;
        targetWeight = source.getTargetWeight().value;
    }

    /**
     * Converts this Jackson-friendly adapted day object into the model's {@code Day} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted day.
     */
    public Profile toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Date.class.getSimpleName()));
        }

        final Name modelName = new Name(name);

        if (id == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Weight.class.getSimpleName()));
        }
        if (!ID.isValidId(id)) {
            throw new IllegalValueException(Weight.MESSAGE_CONSTRAINTS);
        }
        final ID modelID = new ID(id);

        if (id == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Weight.class.getSimpleName()));
        }
        if (!Height.isValidHeight(height)) {
            throw new IllegalValueException(Weight.MESSAGE_CONSTRAINTS);
        }
        final Height modelHeight = new Height(height);

        if (targetWeight == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Weight.class.getSimpleName()));
        }
        if (!Weight.isValidWeight(targetWeight)) {
            throw new IllegalValueException(Weight.MESSAGE_CONSTRAINTS);
        }
        final Weight modelWeight = new Weight(targetWeight);

        return new Profile(modelName, modelID, modelHeight, modelWeight);
    }

}
