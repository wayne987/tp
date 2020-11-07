package seedu.address.testutil;

import seedu.address.model.day.Weight;
import seedu.address.model.person.Height;
import seedu.address.model.person.ID;
import seedu.address.model.person.Name;
import seedu.address.model.person.Profile;


public class TypicalProfiles {

    public static final Profile DEFAULT_PROFILE =
            new Profile(new Name("DEFAULT"), new ID(), new Height(), new Weight());
    public static final Profile JON =
            new Profile(new Name("Jon"), new ID("1111"), new Height("170"), new Weight("50"));
}
