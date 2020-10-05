package seedu.address.model.person.calorie;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class CalorieCount {

    public static final String MESSAGE_CONSTRAINTS =
            "Calorie Count should only contain numeric characters and spaces, and it should not be blank";

    public static final String VALIDATION_REGEX = "[1-9][\\p{Digit}]*";

    public final String CALORIE_COUNT;

    public CalorieCount(String calorieCount) {
        requireNonNull(calorieCount);
        checkArgument(isValidCalorieCount(calorieCount), MESSAGE_CONSTRAINTS);
        CALORIE_COUNT = calorieCount;
    }

    public static boolean isValidCalorieCount(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return CALORIE_COUNT;
    }


}

