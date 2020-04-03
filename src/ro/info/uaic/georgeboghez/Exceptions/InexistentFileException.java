package ro.info.uaic.georgeboghez.Exceptions;

/**
 * Extends the Exception class in order to create a new exception for displaying that the specified file doesn't exist locally.
 */
public class InexistentFileException extends Exception {
    public InexistentFileException() {
        super("File doesn't exist.");
    }
}
