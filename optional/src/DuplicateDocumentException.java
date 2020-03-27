public class DuplicateDocumentException extends Exception {
    public DuplicateDocumentException() {
        super("The document already belongs to the catalog");
    }
}
