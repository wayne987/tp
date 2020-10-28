package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.address.model.calorie.CalorieCount;
import seedu.address.model.calorie.Food;
import seedu.address.model.calorie.Input;
import seedu.address.model.calorie.Time;


public class JsonAdaptedInputTest {
    private static final String INVALID_TIME = "TEST";
    private static final String INVALID_FOOD = "";
    private static final String INVALID_CALORIES = "TEST";

    private static final String VALID_TIME = "1230";
    private static final String VALID_FOOD = "Bread";
    private static final String VALID_CALORIES = "123";
    private static final Input VALID_INPUT = new Input(new Time(VALID_TIME), new Food(VALID_FOOD),
            new CalorieCount(VALID_CALORIES));

    @Test
    public void toModelType_validDayDetails_returnsDay() throws Exception {
        JsonAdaptedInput input = new JsonAdaptedInput(VALID_INPUT);
        assertEquals(VALID_INPUT, input.toModelType());
    }
}
