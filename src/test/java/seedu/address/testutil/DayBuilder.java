package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.day.Address;
import seedu.address.model.day.Date;
import seedu.address.model.day.Day;
import seedu.address.model.day.Email;
import seedu.address.model.day.Weight;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Day objects.
 */
public class DayBuilder {

    public static final String DEFAULT_DATE = "010120";
    public static final String DEFAULT_WEIGHT = "42";
    public static final String DEFAULT_EMAIL = "alice@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";

    private Date date;
    private Weight weight;
    private Email email;
    private Address address;
    private Set<Tag> tags;

    /**
     * Creates a {@code DayBuilder} with the default details.
     */
    public DayBuilder() {
        date = new Date(DEFAULT_DATE);
        weight = new Weight(DEFAULT_WEIGHT);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        tags = new HashSet<>();
    }

    /**
     * Initializes the DayBuilder with the data of {@code dayToCopy}.
     */
    public DayBuilder(Day dayToCopy) {
        date = dayToCopy.getDate();
        weight = dayToCopy.getWeight();
        email = dayToCopy.getEmail();
        address = dayToCopy.getAddress();
        tags = new HashSet<>(dayToCopy.getTags());
    }

    /**
     * Sets the {@code Date} of the {@code Day} that we are building.
     */
    public DayBuilder withDate(String date) {
        this.date = new Date(date);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Day} that we are building.
     */
    public DayBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Day} that we are building.
     */
    public DayBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Weight} of the {@code Day} that we are building.
     */
    public DayBuilder withWeight(String weight) {
        this.weight = new Weight(weight);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Day} that we are building.
     */
    public DayBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    public Day build() {
        return new Day(date, weight, email, address, tags);
    }

}
