package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.day.Date.isCorrectRegrex;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.calorie.CalorieCount;
import seedu.address.model.calorie.Exercise;
import seedu.address.model.calorie.Food;
import seedu.address.model.calorie.Time;
import seedu.address.model.day.Date;
import seedu.address.model.day.Weight;
import seedu.address.model.person.Height;
import seedu.address.model.person.ID;
import seedu.address.model.person.Name;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";
    public static final String MESSAGE_DUPLICATE_PREFIX = "There should only be one prefix for each field";
    public static final double HEAVIEST_PERSON = 635;
    public static final double LIGHTEST_PERSON = 2.13;

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String date} into a {@code Date}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code date} is invalid.
     */
    public static Date parseDate(String date) throws ParseException {
        requireNonNull(date);
        String trimmedDate = date.trim();
        if (!isCorrectRegrex(trimmedDate)) {
            throw new ParseException(Date.MESSAGE_CONSTRAINTS);
        }
        try {
            LocalDate.parse(trimmedDate);
        } catch (DateTimeParseException e) {
            String errorMessage = (e.toString().split("parsed: ")[1]);
            throw new ParseException(errorMessage);
        }
        return new Date(trimmedDate);
    }

    /**
     * Parses a {@code String weight} into a {@code Weight}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code weight} is invalid.
     */
    public static Weight parseWeight(String weight) throws ParseException {
        requireNonNull(weight);
        String trimmedWeight = weight.trim();
        if (!Weight.isValidWeight(trimmedWeight)) {
            throw new ParseException(Weight.MESSAGE_CONSTRAINTS);
        }

        double w = Double.parseDouble(weight);

        if (w < LIGHTEST_PERSON) {
            throw new ParseException(Weight.MESSAGE_TOO_LIGHT);
        }
        if (w > HEAVIEST_PERSON) {
            throw new ParseException(Weight.MESSAGE_TOO_HEAVY);
        }
        return new Weight(trimmedWeight);
    }

    /**
     * Parses a {@code String time} into @code Time.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Time parseTime(String time) throws ParseException {
        requireNonNull(time);
        String trimmedTime = time.trim();
        if (!Time.isValidTime(trimmedTime)) {
            throw new ParseException(Time.MESSAGE_CONSTRAINTS);
        }
        return new Time(trimmedTime);
    }

    /**
     * Parses a {@code String exercise} into @code Exercise.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Exercise parseExercise(String exercise, Boolean isOut) throws ParseException {
        requireNonNull(exercise);
        String trimmedExercise = exercise.trim();
        if (!isOut) {
            throw new ParseException(Exercise.MESSAGE_CONSTRAINTS_WRONG_TYPE);
        }
        if (!Exercise.isValidExercise(trimmedExercise)) {
            throw new ParseException(Exercise.MESSAGE_CONSTRAINTS);
        }
        return new Exercise(trimmedExercise);
    }

    /**
     * Parses a {@code String calorieCount} into @code CalorieCount.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static CalorieCount parseCalorieCount(String calorieCount) throws ParseException {
        requireNonNull(calorieCount);
        String trimmedCalorieCount = calorieCount.trim();
        if (!CalorieCount.isValidCalorieCount(trimmedCalorieCount)) {
            throw new ParseException(CalorieCount.MESSAGE_CONSTRAINTS);
        }
        return new CalorieCount(trimmedCalorieCount);
    }

    /**
     * Parses a {@code String food} into @code Food.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Food parseFood(String food, Boolean isOut) throws ParseException {
        requireNonNull(food);
        String trimmedFood = food.trim();
        if (isOut) {
            throw new ParseException(Food.MESSAGE_CONSTRAINTS_WRONG_TYPE);
        }
        if (!Food.isValidFood(trimmedFood)) {
            throw new ParseException(Food.MESSAGE_CONSTRAINTS);
        }
        return new Food(trimmedFood);
    }

    /**
     * Check if {@code String type} is of correct type.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static boolean parseType(String type) throws ParseException {
        requireNonNull(type);
        String trimmedType = type.trim().toLowerCase();
        switch (trimmedType) {
        case "out":
            return true;
        case "in":
            return false;
        default:
            throw new ParseException("type can only be either in/out");
        }
    }

    /**
     * Parse {@code String date} into LocalDate
     */
    public static LocalDate parseLocalDate(String date) throws ParseException {
        requireNonNull(date);
        String toCheck = date.trim();
        if (!isCorrectRegrex(toCheck)) {
            throw new ParseException(Date.MESSAGE_CONSTRAINTS);
        }
        LocalDate result;
        try {
            result = LocalDate.parse(toCheck);
        } catch (DateTimeParseException e) {
            String errorMessage = (e.toString().split("parsed: ")[1]);
            throw new ParseException(errorMessage);
        }

        return result;
    }

    /**
     * Parses a {@code String name} into @code Name.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String id} into @code ID.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static ID parseID(String id) throws ParseException {
        requireNonNull(id);
        String trimmedID = id.trim();
        if (!ID.isValidId(trimmedID)) {
            throw new ParseException(ID.MESSAGE_CONSTRAINTS);
        }
        return new ID(trimmedID);
    }

    /**
     * Parses a {@code String height} into @code Height.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Height parseHeight(String height) throws ParseException {
        requireNonNull(height);
        String trimmedHeight = height.trim();
        if (!Height.isValidHeight(trimmedHeight)) {
            throw new ParseException(Height.MESSAGE_CONSTRAINTS);
        }
        return new Height(trimmedHeight);
    }

    /**
     * Parses a {@code String BMI} into @code BMI.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static double parseBmi(String bmi) throws ParseException {
        requireNonNull(bmi);
        String trimmedHeight = bmi.trim();
        try {
            return Double.parseDouble(bmi);
        } catch (Exception e) {
            throw new ParseException("Please input a valid BMI");
        }
    }
}
