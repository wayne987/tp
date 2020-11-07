package seedu.address.testutil;

import seedu.address.model.calorie.CalorieManager;
import seedu.address.model.calorie.Input;
import seedu.address.model.calorie.Output;

public class CalorieManagerBuilder {

    private CalorieManager calorieManager;

    /**
     * Creates a {@code CalorieManagerBuilder}.
     */
    public CalorieManagerBuilder() {
        calorieManager = new CalorieManager();
    }

    /**
     * Adds an {@code Input} to the {@code CalorieManager} that we are building.
     */
    public CalorieManagerBuilder addInput(Input input) {
        calorieManager.addCalorieInput(input);
        return this;
    }

    /**
     * Adds an {@code Output} to the {@code CalorieManager} that we are building.
     */
    public CalorieManagerBuilder addOutput(Output output) {
        calorieManager.addCalorieOutput(output);
        return this;
    }

    public CalorieManager build() {
        return calorieManager;
    }
}
