package ro.info.uaic.georgeboghez.Commands;

import ro.info.uaic.georgeboghez.CatalogAndDocuments.*;
import ro.info.uaic.georgeboghez.Exceptions.*;

/**
 * The class extends Command and opens the specified file found inside the Catalog.
 */
public class ViewCommand extends Command {
    public ViewCommand(String name) {
        super(name);
    }

    /**
     * the method calls catalog's getDocument method which returns the document given as an argument and opens it using Document's method openDocument
     * @param catalog a Catalog object which will be manipulated through different actions.
     * @param args the arguments of the command
     * @return the unmodified catalog
     * @throws InvalidNumberOfArgumentsException if the user writes down arguments besides the command's name, the custom exception will be thrown.
     * @throws CouldntFindInCatalogException if the specified file to be added doesn't exist, the custom exception will be thrown.
     */
    @Override
    public Catalog execute(Catalog catalog, String... args) throws InvalidNumberOfArgumentsException, CouldntFindInCatalogException {
        if(args.length != 1) {
            throw new InvalidNumberOfArgumentsException();
        }

        catalog.getDocument(args[0]).openDocument();

        return catalog;
    }

    /**
     * Prints the command's name and the argument it needs in order to run properly.
     * @return a string representing an indication on how to run the command.
     */
    @Override
    public String toString() {
        return getName() + " [document name]";
    }
}
