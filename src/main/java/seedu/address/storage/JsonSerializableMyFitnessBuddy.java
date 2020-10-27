package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.MyFitnessBuddy;
import seedu.address.model.ReadOnlyMyFitnessBuddy;
import seedu.address.model.person.Person;


/**
 * An Immutable My Fitness Buddy that is serializable to JSON format.
 */
@JsonRootName(value = "My Fitness Buddy")
class JsonSerializableMyFitnessBuddy {

    private final JsonAdaptedPerson person;

    /**
     * Constructs a {@code JsonSerializableMyFitnessBuddy} with the given persons.
     */
    @JsonCreator
    public JsonSerializableMyFitnessBuddy(@JsonProperty("person") JsonAdaptedPerson person) {
        this.person = person;
    }

    /**
     * Converts a given {@code ReadOnlyMyFitnessBuddy} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableMyFitnessBuddy}.
     */
    public JsonSerializableMyFitnessBuddy(ReadOnlyMyFitnessBuddy source) {
        person = new JsonAdaptedPerson(source.getPerson());
    }

    /**
     * Converts this address book into the model's {@code MyFitnessBuddy} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public MyFitnessBuddy toModelType() throws IllegalValueException {
        Person modelPerson = person.toModelType();
        MyFitnessBuddy modelMyFitnessBuddy = new MyFitnessBuddy();
        modelMyFitnessBuddy.setPerson(modelPerson);
        return modelMyFitnessBuddy;
    }

}
