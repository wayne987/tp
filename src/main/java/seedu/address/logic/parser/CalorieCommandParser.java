package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CALORIE_COUNT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CALORIE_TYPE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EXERCISE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FOOD;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;

import java.util.stream.Stream;

import seedu.address.logic.commands.CalorieCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.day.calorie.Calorie;
import seedu.address.model.day.calorie.CalorieCount;
import seedu.address.model.day.calorie.Exercise;
import seedu.address.model.day.calorie.Food;
import seedu.address.model.day.calorie.Input;
import seedu.address.model.day.calorie.Output;
import seedu.address.model.day.calorie.Time;


public class CalorieCommandParser implements Parser<CalorieCommand> {
    @Override
    public CalorieCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
            ArgumentTokenizer.tokenize(args, PREFIX_CALORIE_TYPE, PREFIX_TIME, PREFIX_EXERCISE, PREFIX_FOOD,
                    PREFIX_CALORIE_COUNT);

        String type = ParserUtil.parseCalorieType(argMultimap.getValue(PREFIX_CALORIE_TYPE).get());
        Calorie calorie;
        if (type.equals("in")) {
            if (!arePrefixesPresent(argMultimap, PREFIX_CALORIE_TYPE, PREFIX_TIME, PREFIX_FOOD, PREFIX_CALORIE_COUNT)
                    || !argMultimap.getPreamble().isEmpty()) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CalorieCommand.MESSAGE_USAGE));
            }
            Time time = ParserUtil.parseTime(argMultimap.getValue(PREFIX_TIME).get());
            CalorieCount calorieCount = ParserUtil.parseCalorieCount(argMultimap.getValue(PREFIX_CALORIE_COUNT).get());
            Food food = ParserUtil.parseFood(argMultimap.getValue(PREFIX_FOOD).get());
            calorie = new Input(time, food, calorieCount);
        } else {
            if (!arePrefixesPresent(argMultimap, PREFIX_CALORIE_TYPE, PREFIX_TIME, PREFIX_EXERCISE,
                    PREFIX_CALORIE_COUNT)
                    || !argMultimap.getPreamble().isEmpty()) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CalorieCommand.MESSAGE_USAGE));
            }
            Time time = ParserUtil.parseTime(argMultimap.getValue(PREFIX_TIME).get());
            CalorieCount calorieCount = ParserUtil.parseCalorieCount(argMultimap.getValue(PREFIX_CALORIE_COUNT).get());
            Exercise exercise = ParserUtil.parseExercise(argMultimap.getValue(PREFIX_EXERCISE).get());
            calorie = new Output(time, exercise, calorieCount);
        }
        return new CalorieCommand(calorie, type);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
