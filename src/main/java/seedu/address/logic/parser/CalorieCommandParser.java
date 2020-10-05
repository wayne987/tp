package seedu.address.logic.parser;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.CalorieCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.calorie.*;

import java.util.stream.Stream;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

public class CalorieCommandParser  implements Parser<CalorieCommand>{

    @Override
    public CalorieCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_CALORIE_TYPE, PREFIX_TIME, PREFIX_EXERCISE, PREFIX_CALORIE_COUNT);

        if (!arePrefixesPresent(argMultimap, PREFIX_CALORIE_TYPE, PREFIX_TIME, PREFIX_EXERCISE, PREFIX_CALORIE_COUNT)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        String type = ParserUtil.parseCalorieType(argMultimap.getValue(PREFIX_CALORIE_TYPE).get());
//      System.out.println(type);
        Time time = ParserUtil.parseTime(argMultimap.getValue(PREFIX_TIME).get());
//      System.out.println(time);
        CalorieCount calorieCount = ParserUtil.parseCalorieCount(argMultimap.getValue(PREFIX_CALORIE_COUNT).get());
//      System.out.println(calorieCount);

        Calorie calorie;
        if(type.equals("in")){
            //add food?
            calorie = new Calorie(calorieCount,time);
        }else{
            Exercise exercise = ParserUtil.parseExercise(argMultimap.getValue(PREFIX_EXERCISE).get());
            calorie = new Output(time,exercise,calorieCount);
        }
//        System.out.println(exercise);



        return new CalorieCommand(calorie);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
