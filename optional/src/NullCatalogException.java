public class NullCatalogException extends Exception {
    public NullCatalogException() {
        super("Null Catalog. Consider creating a new catalog or loading an existing one.");
    }
}
