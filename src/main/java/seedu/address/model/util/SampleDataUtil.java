package seedu.address.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.Person;
import seedu.address.model.ReadOnlyPerson;
import seedu.address.model.day.Date;
import seedu.address.model.day.Day;
import seedu.address.model.day.Weight;
import seedu.address.model.day.calorie.CalorieCount;
import seedu.address.model.day.calorie.CalorieManager;
import seedu.address.model.day.calorie.Exercise;
import seedu.address.model.day.calorie.Food;
import seedu.address.model.day.calorie.Input;
import seedu.address.model.day.calorie.Output;
import seedu.address.model.day.calorie.Time;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
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

    public static ReadOnlyPerson getSamplePerson() {
        Person sampleAb = new Person();
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
