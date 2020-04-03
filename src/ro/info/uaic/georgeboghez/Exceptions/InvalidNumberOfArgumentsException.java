package ro.info.uaic.georgeboghez.Exceptions;

/**
 * Extends the Exception class in order to create a new exception for reminding the user that the command needs more or fewer arguments.
 */
public class InvalidNumberOfArgumentsException extends Exception {
    public InvalidNumberOfArgumentsException() {
        super("Invalid number of arguments. Consider listing all available commands with 'commands'.");
    }
}
