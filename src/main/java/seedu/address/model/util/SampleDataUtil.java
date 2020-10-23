package seedu.address.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.MyFitnessBuddy;
import seedu.address.model.ReadOnlyMyFitnessBuddy;
import seedu.address.model.day.Date;
import seedu.address.model.day.Day;
import seedu.address.model.day.Weight;
import seedu.address.model.calorie.CalorieCount;
import seedu.address.model.calorie.CalorieManager;
import seedu.address.model.calorie.Exercise;
import seedu.address.model.calorie.Food;
import seedu.address.model.calorie.Input;
import seedu.address.model.calorie.Output;
import seedu.address.model.calorie.Time;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code MyFitnessBuddy} with sample data.
 */
public class SampleDataUtil {
    public static Day[] getSampleDay() {
        List<Input> emptyInput = new ArrayList<>();
        List<Output> emptyOutput = new ArrayList<>();
        List<Input> sampleInput = new ArrayList<>();
        sampleInput.add(new Input(new Time("1230"), new Food("Laksa"), new CalorieCount("800")));
        List<Output> sampleOutput = new ArrayList<>();
        sampleOutput.add(new Output(new Time("1800"), new Exercise("Run"), new CalorieCount("200")));
        CalorieManager cm = new CalorieManager(sampleInput, sampleOutput);

        return new Day[] {
            new Day(new Date("2020-10-11"), new Weight("110"), getTagSet("5BX")),
            new Day(new Date("2020-10-12"), new Weight("120"), getTagSet(), cm),
            new Day(new Date("2020-10-13"), new Weight("130"), getTagSet(), cm),
            new Day(new Date("2020-10-14"), new Weight("140"), getTagSet(), cm),
        };
    }

    public static ReadOnlyMyFitnessBuddy getSampleMyFitnessBuddy() {
        MyFitnessBuddy sampleAb = new MyFitnessBuddy();
        for (Day sampleDay : getSampleDay()) {
            sampleAb.addDay(sampleDay);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
