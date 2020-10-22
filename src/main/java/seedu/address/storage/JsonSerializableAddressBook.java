package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.MyFitnessBuddy;
import seedu.address.model.ReadOnlyMyFitnessBuddy;
import seedu.address.model.day.Day;


/**
 * An Immutable AddressBook that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableAddressBook {

    public static final String MESSAGE_DUPLICATE_DAY = "Days list contains duplicate day(s).";

    private final List<JsonAdaptedDay> days = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableAddressBook} with the given days.
     */
    @JsonCreator
    public JsonSerializableAddressBook(@JsonProperty("days") List<JsonAdaptedDay> days) {
        this.days.addAll(days);
    }

    /**
     * Converts a given {@code ReadOnlyAddressBook} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableAddressBook(ReadOnlyMyFitnessBuddy source) {
        days.addAll(source.getDayList().stream().map(JsonAdaptedDay::new).collect(Collectors.toList()));
    }

    /**
     * Converts this address book into the model's {@code AddressBook} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public MyFitnessBuddy toModelType() throws IllegalValueException {
        MyFitnessBuddy myFitnessBuddy = new MyFitnessBuddy();
        for (JsonAdaptedDay jsonAdaptedDay : days) {
            Day day = jsonAdaptedDay.toModelType();
            if (myFitnessBuddy.hasDay(day)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_DAY);
            }
            myFitnessBuddy.addDay(day);
        }
        return myFitnessBuddy;
    }

}
