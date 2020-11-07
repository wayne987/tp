package seedu.address.testutil;

import seedu.address.model.person.Person;

public class TypicalPerson {

    public static final Person VALID_PERSON = new PersonBuilder().withProfile(TypicalProfiles.VALID_PROFILE)
            .withDays(TypicalDays.getTypicalDays()).build();
}
