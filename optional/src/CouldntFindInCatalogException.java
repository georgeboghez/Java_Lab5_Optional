public class CouldntFindInCatalogException extends Exception {
    public CouldntFindInCatalogException() {
        super("The specified document doesn't belong to this catalog");
    }
}
