package ro.info.uaic.georgeboghez.Exceptions;

/**
 * Extends the Exception class in order to create a new exception for displaying that the catalog already contains the specified document and it would be a duplicate.
 */
public class DuplicateDocumentException extends Exception {
    public DuplicateDocumentException() {
        super("The document already belongs to the catalog");
    }
}
