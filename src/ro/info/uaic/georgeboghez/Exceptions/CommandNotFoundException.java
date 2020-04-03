package ro.info.uaic.georgeboghez.Exceptions;

/**
 * Extends the Exception class in order to create a new exception for the moment a command inserted by the user is not recognized
 */
public class CommandNotFoundException extends Exception {
    public CommandNotFoundException() {
        super("Command not found. Consider listing all available commands with 'commands'.");
    }
}
