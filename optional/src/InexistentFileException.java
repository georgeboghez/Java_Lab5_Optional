public class InexistentFileException extends Exception {
    public InexistentFileException() {
        super("File doesn't exist.");
    }
}
