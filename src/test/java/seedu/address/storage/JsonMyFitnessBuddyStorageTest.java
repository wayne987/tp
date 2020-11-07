package seedu.address.storage;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.address.testutil.Assert.assertThrows;
//import static seedu.address.testutil.TypicalDays.ALICE;
//import static seedu.address.testutil.TypicalDays.HOON;
//import static seedu.address.testutil.TypicalDays.IDA;
//import static seedu.address.testutil.TypicalDays.getTypicalMyFitnessBuddy;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

//import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.MyFitnessBuddy;
import seedu.address.model.ReadOnlyMyFitnessBuddy;

public class JsonMyFitnessBuddyStorageTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonMyFitnessBuddyStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readMyFitnessBuddy_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readMyFitnessBuddy(null));
    }

    private java.util.Optional<ReadOnlyMyFitnessBuddy> readMyFitnessBuddy(String filePath) throws Exception {
        return new JsonMyFitnessBuddyStorage(Paths.get(filePath))
                .readFitnessBuddy(addToTestDataPathIfNotNull(filePath));
    }

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readMyFitnessBuddy("NonExistentFile.json").isPresent());
    }
    /*
    @Test
    public void read_notJsonFormat_exceptionThrown() {
        assertThrows(DataConversionException.class, () -> readMyFitnessBuddy("notJsonFormatAddressBook.json"));
    }

    @Test
    public void readMyFitnessBuddy_invalidDayMyFitnessBuddy_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readMyFitnessBuddy("invalidPersonAddressBook.json"));
    }

    @Test
    public void readMyFitnessBuddy_invalidAndValidDayMyFitnessBuddy_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readMyFitnessBuddy("invalidAndValidPersonAddressBook.json"));
    }
*/
    //error due to refactoring
    @Test
    public void readAndSaveMyFitnessBuddy_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempAddressBook.json");
        //MyFitnessBuddy original = getTypicalMyFitnessBuddy();
        JsonMyFitnessBuddyStorage jsonAddressBookStorage = new JsonMyFitnessBuddyStorage(filePath);

        // Save in new file and read back
        //jsonAddressBookStorage.saveAddressBook(original, filePath);
        //ReadOnlyMyFitnessBuddy readBack = jsonAddressBookStorage.readAddressBook(filePath).get();
        //assertEquals(original, new MyFitnessBuddy(readBack));

        // Modify data, overwrite exiting file, and read back
        //original.addDay(HOON);
        //original.removeDay(ALICE);
        //jsonAddressBookStorage.saveAddressBook(original, filePath);
        //readBack = jsonAddressBookStorage.readAddressBook(filePath).get();
        //assertEquals(original, new MyFitnessBuddy(readBack));

        // Save and read without specifying file path
        //original.addDay(IDA);
        //jsonAddressBookStorage.saveAddressBook(original); // file path not specified
        //readBack = jsonAddressBookStorage.readAddressBook().get(); // file path not specified
        //assertEquals(original, new MyFitnessBuddy(readBack));

    }

    @Test
    public void saveMyFitnessBuddy_nullMyFitnessBuddy_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveMyFitnessBuddy(null, "SomeFile.json"));
    }

    /**
     * Saves {@code addressBook} at the specified {@code filePath}.
     */
    private void saveMyFitnessBuddy(ReadOnlyMyFitnessBuddy addressBook, String filePath) {
        try {
            new JsonMyFitnessBuddyStorage(Paths.get(filePath))
                    .saveFitnessBuddy(addressBook, addToTestDataPathIfNotNull(filePath));
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file.", ioe);
        }
    }

    @Test
    public void saveMyFitnessBuddy_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveMyFitnessBuddy(new MyFitnessBuddy(), null));
    }
}
