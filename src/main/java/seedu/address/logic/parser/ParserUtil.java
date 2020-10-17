package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.day.Date;
import seedu.address.model.day.Email;
import seedu.address.model.day.Weight;
import seedu.address.model.day.calorie.CalorieCount;
import seedu.address.model.day.calorie.Exercise;
import seedu.address.model.day.calorie.Food;
import seedu.address.model.day.calorie.Time;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

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
        if (!Date.isValidDate(trimmedDate)) {
            throw new ParseException(Date.MESSAGE_CONSTRAINTS);
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
        return new Weight(trimmedWeight);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses a {@code String CalorieType} into an different type.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static String parseCalorieType(String type) throws ParseException {
        requireNonNull(type);
        String trimmedType = type.trim();
        if (trimmedType.equals("in") || trimmedType.equals("out")) {
            return trimmedType;
        } else {
            throw new ParseException("wrong calorie direction");
        }
    }

    /**
     * Parses a {@code String time} into @code Time.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Time parseTime(String time) throws ParseException {
        requireNonNull(time);
        String trimmedTime = time.trim();
        if (!Time.isValidTime(trimmedTime)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Time(trimmedTime);
    }

    /**
     * Parses a {@code String exercise} into @code Exercise.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Exercise parseExercise(String exercise) throws ParseException {
        requireNonNull(exercise);
        String trimmedExercise = exercise.trim();
        if (!Exercise.isValidExercise(trimmedExercise)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
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
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new CalorieCount(trimmedCalorieCount);
    }

    /**
     * Parses a {@code String food} into @code Food.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static Food parseFood(String food) throws ParseException {
        requireNonNull(food);
        String trimmedFood = food.trim();
        if (!Food.isValidFood(trimmedFood)) {
            throw new ParseException(Food.MESSAGE_CONSTRAINTS);
        }
        return new Food(trimmedFood);
    }
}
