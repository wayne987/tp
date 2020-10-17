package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.day.calorie.CalorieManager;
import seedu.address.model.day.calorie.Input;
import seedu.address.model.day.calorie.Output;





/**
 * Jackson-friendly version of {@link seedu.address.model.day.calorie.Calorie}.
 */
class JsonAdaptedCalorieManager {

    private final List<JsonAdaptedInput> inputList = new ArrayList<>();
    private final List<JsonAdaptedOutput> outputList = new ArrayList<>();

    /**
     * Constructs a {@code JsonCalorieManager} with the given day details.
     */
    @JsonCreator
    public JsonAdaptedCalorieManager(@JsonProperty("inputList") List<JsonAdaptedInput> inputList,
                                     @JsonProperty("outputList") List<JsonAdaptedOutput> outputList) {
        if (inputList != null) {
            this.inputList.addAll(inputList);
        }
        if (outputList != null) {
            this.outputList.addAll(outputList);
        }
    }

    public List<JsonAdaptedInput> getInputList() {
        return inputList;
    }

    public List<JsonAdaptedOutput> getOutputList() {
        return outputList;
    }

    /**
     * Converts this Jackson-friendly adapted CalorieManager
     * object into the CalorieManager {@code CalorieManager} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted day.
     */
    public CalorieManager toModelType() throws IllegalValueException {
        final List<Input> dayInputs = new ArrayList<>();
        for (JsonAdaptedInput input : inputList) {
            dayInputs.add(input.toModelType());
        }

        final List<Output> dayOutputs = new ArrayList<>();
        for (JsonAdaptedOutput output : outputList) {
            dayOutputs.add(output.toModelType());
        }
        return new CalorieManager(dayInputs, dayOutputs);
    }

}
