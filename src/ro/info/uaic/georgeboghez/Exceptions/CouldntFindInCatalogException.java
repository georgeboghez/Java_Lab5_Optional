package ro.info.uaic.georgeboghez.Exceptions;

/**
 * Extends the Exception class in order to create a new exception for warning the user the catalog doesn't contain a specified document.
 */
public class CouldntFindInCatalogException extends Exception {
    public CouldntFindInCatalogException() {
        super("The specified document doesn't belong to this catalog");
    }
}
