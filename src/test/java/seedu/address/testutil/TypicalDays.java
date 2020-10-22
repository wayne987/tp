package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_2;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WEIGHT_1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_WEIGHT_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.MyFitnessBuddy;
import seedu.address.model.day.Day;

/**
 * A utility class containing a list of {@code Day} objects to be used in tests.
 */
public class TypicalDays {

    public static final Day ALICE = new DayBuilder().withDate("2020-11-23")
            .withWeight("45")
            .withTags("friends").build();
    public static final Day BENSON = new DayBuilder().withDate("2020-05-12")
            .withTags("owesMoney", "friends").build();
    public static final Day CARL = new DayBuilder().withDate("2020-01-23").withWeight("75").build();
    public static final Day DANIEL = new DayBuilder().withDate("2020-01-13").withWeight("66")
           .withTags("friends").build();
    public static final Day ELLE = new DayBuilder().withDate("2020-09-12").withWeight("42")
          .build();
    public static final Day FIONA = new DayBuilder().withDate("2020-03-01").withWeight("51")
           .build();
    public static final Day GEORGE = new DayBuilder().withDate("2019-12-25").withWeight("73")
           .build();

    // Manually added
    public static final Day HOON = new DayBuilder().withDate("2020-06-09").withWeight("56")
           .build();
    public static final Day IDA = new DayBuilder().withDate("2020-10-11").withWeight("40")
          .build();

    // Manually added - Day's details found in {@code CommandTestUtil}
    public static final Day AMY = new DayBuilder().withDate(VALID_DATE_1).withWeight(VALID_WEIGHT_1)
           .withTags(VALID_TAG_FRIEND).build();
    public static final Day BOB = new DayBuilder().withDate(VALID_DATE_2).withWeight(VALID_WEIGHT_2)
           .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalDays() {} // prevents instantiation

    /**
     * Returns an {@code MyFitnessBuddy} with all the typical days.
     */
    public static MyFitnessBuddy getTypicalMyFitnessBuddy() {
        MyFitnessBuddy ab = new MyFitnessBuddy();
        for (Day day : getTypicalDays()) {
            ab.addDay(day);
        }
        return ab;
    }

    public static List<Day> getTypicalDays() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
