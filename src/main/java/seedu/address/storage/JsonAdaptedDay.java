package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.day.Date;
import seedu.address.model.day.Day;
import seedu.address.model.day.Weight;
import seedu.address.model.calorie.CalorieManager;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Day}.
 */
class JsonAdaptedDay {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Day's %s field is missing!";

    private final String date;
    private final String weight;
    private final JsonAdaptedCalorieManager calorieManager;
    private final List<JsonAdaptedTag> tagged = new ArrayList<>();


    /**
     * Constructs a {@code JsonAdaptedDay} with the given day details.
     */
    @JsonCreator
    public JsonAdaptedDay(@JsonProperty("date") String date, @JsonProperty("weight") String weight,
                          @JsonProperty("tagged") List<JsonAdaptedTag> tagged,
                          @JsonProperty("inputList") List<JsonAdaptedInput> inputList,
                          @JsonProperty("outputList") List<JsonAdaptedOutput> outputList) {
        this.date = date;
        this.weight = weight;
        if (tagged != null) {
            this.tagged.addAll(tagged);
        }
        calorieManager = new JsonAdaptedCalorieManager(inputList, outputList);
    }

    /**
     * Converts a given {@code Date} into this class for Jackson use.
     */
    public JsonAdaptedDay(Day source) {
        date = source.getDate().value;
        weight = source.getWeight().value;
        tagged.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
        calorieManager = new JsonAdaptedCalorieManager(new ArrayList<>(),
                                                       new ArrayList<>());
        calorieManager.getInputList().addAll(source.getCalorieManager().getCalorieInputList().stream()
                .map(JsonAdaptedInput::new)
                .collect(Collectors.toList()));
        calorieManager.getOutputList().addAll(source.getCalorieManager().getCalorieOutputList().stream()
                .map(JsonAdaptedOutput::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted day object into the model's {@code Day} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted day.
     */
    public Day toModelType() throws IllegalValueException {
        final List<Tag> dayTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tagged) {
            dayTags.add(tag.toModelType());
        }

        if (date == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Date.class.getSimpleName()));
        }
        if (!Date.isValidDate(date)) {
            throw new IllegalValueException(Date.MESSAGE_CONSTRAINTS);
        }
        final Date modelDate = new Date(date);

        if (weight == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Weight.class.getSimpleName()));
        }
        if (!Weight.isValidWeight(weight)) {
            throw new IllegalValueException(Weight.MESSAGE_CONSTRAINTS);
        }
        final Weight modelWeight = new Weight(weight);

        if (calorieManager == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    CalorieManager.class.getSimpleName()));
        }

        final CalorieManager modelCalorieManager = calorieManager.toModelType();

        final Set<Tag> modelTags = new HashSet<>(dayTags);

        return new Day(modelDate, modelWeight, modelTags, modelCalorieManager);
    }

}
