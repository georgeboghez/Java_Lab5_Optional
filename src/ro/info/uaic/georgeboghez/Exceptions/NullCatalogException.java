package ro.info.uaic.georgeboghez.Exceptions;

/**
 * Extends the Exception class in order to create a new exception for warning the user that he didn't create a new catalog nor did he load one.
 */
public class NullCatalogException extends Exception {
    public NullCatalogException() {
        super("Null Catalog. Consider creating a new catalog or loading an existing one.");
    }
}
