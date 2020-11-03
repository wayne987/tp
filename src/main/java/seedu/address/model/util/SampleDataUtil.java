package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.MyFitnessBuddy;
import seedu.address.model.ReadOnlyMyFitnessBuddy;
import seedu.address.model.calorie.CalorieCount;
import seedu.address.model.calorie.CalorieManager;
import seedu.address.model.calorie.Exercise;
import seedu.address.model.calorie.Food;
import seedu.address.model.calorie.Input;
import seedu.address.model.calorie.Output;
import seedu.address.model.calorie.Time;
import seedu.address.model.day.Date;
import seedu.address.model.day.Day;
import seedu.address.model.day.UniqueDayList;
import seedu.address.model.day.Weight;
import seedu.address.model.person.Height;
import seedu.address.model.person.ID;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Profile;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code MyFitnessBuddy} with sample data.
 */
public class SampleDataUtil {
    public static UniqueDayList getSampleDays() {
        ObservableList<Input> sampleInput = FXCollections.observableArrayList();
        sampleInput.add(new Input(new Time("1230"), new Food("Laksa"), new CalorieCount("800")));
        ObservableList<Output> sampleOutput = FXCollections.observableArrayList();
        sampleOutput.add(new Output(new Time("1800"), new Exercise("Run"), new CalorieCount("200")));
        CalorieManager sampleCalorieManager = new CalorieManager(sampleInput, sampleOutput);
        UniqueDayList sampleDays = new UniqueDayList();
        sampleDays.add(new Day(new Date("2020-10-11"), new Weight("110"), getTagSet(), sampleCalorieManager));
        sampleDays.add(new Day(new Date("2020-10-12"), new Weight("120"), getTagSet("5BX")));
        return sampleDays;
    }

    public static Person getSamplePerson() {
        Profile sampleProfile = new Profile(new Name("Sample Person"),
                new ID("2103"), new Height("170"), new Weight("60"));
        Person samplePerson = new Person(sampleProfile, getSampleDays());
        samplePerson.setStartingDay(new Date("2020-09-30"));
        System.out.println(samplePerson.getProfile().getStartDate());
        return samplePerson;
    }

    public static Person getSamplePerson2() {
        Profile sampleProfile = new Profile(new Name("Sample Person 2"),
                new ID("2104"), new Height("170"), new Weight("60"));
        Person samplePerson = new Person(sampleProfile, getSampleDays());
        samplePerson.setStartingDay(new Date("2020-08-29"));
        return samplePerson;
    }

    public static ReadOnlyMyFitnessBuddy getSampleMyFitnessBuddy() {
        MyFitnessBuddy sampleMyFitnessBuddy = new MyFitnessBuddy();
        sampleMyFitnessBuddy.addPerson(getSamplePerson());
        sampleMyFitnessBuddy.addPerson(getSamplePerson2());
        return sampleMyFitnessBuddy;
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
