package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.MyFitnessBuddy;
import seedu.address.model.ReadOnlyMyFitnessBuddy;

/**
 * Represents a storage for {@link MyFitnessBuddy}.
 */
public interface AddressBookStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getAddressBookFilePath();

    /**
     * Returns AddressBook data as a {@link ReadOnlyMyFitnessBuddy}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyMyFitnessBuddy> readAddressBook() throws DataConversionException, IOException;

    /**
     * @see #getAddressBookFilePath()
     */
    Optional<ReadOnlyMyFitnessBuddy> readAddressBook(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyMyFitnessBuddy} to the storage.
     * @param addressBook cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveAddressBook(ReadOnlyMyFitnessBuddy addressBook) throws IOException;

    /**
     * @see #saveAddressBook(ReadOnlyMyFitnessBuddy)
     */
    void saveAddressBook(ReadOnlyMyFitnessBuddy addressBook, Path filePath) throws IOException;

}
