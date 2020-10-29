package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.address.model.calorie.CalorieCount;
import seedu.address.model.calorie.Exercise;
import seedu.address.model.calorie.Output;
import seedu.address.model.calorie.Time;

public class JsonAdaptedOutputTest {
    private static final String INVALID_TIME = "TEST";
    private static final String INVALID_FOOD = "";
    private static final String INVALID_CALORIES = "TEST";

    private static final String VALID_TIME = "1230";
    private static final String VALID_EXERCISE = "Run";
    private static final String VALID_CALORIES = "123";
    private static final Output VALID_OUTPUT = new Output(new Time(VALID_TIME), new Exercise(VALID_EXERCISE),
            new CalorieCount(VALID_CALORIES));

    @Test
    public void toModelType_validDayDetails_returnsDay() throws Exception {
        JsonAdaptedOutput output = new JsonAdaptedOutput(VALID_OUTPUT);
        assertEquals(VALID_OUTPUT, output.toModelType());
    }
}
