package ro.info.uaic.georgeboghez.Commands;

import ro.info.uaic.georgeboghez.CatalogAndDocuments.*;
import ro.info.uaic.georgeboghez.Exceptions.*;

/**
 * The class extends Command and creates a new object Catalog with a specified name on which the user make actions.
 */
public class NewCatalogCommand extends Command {
    public NewCatalogCommand(String name) {
        super(name);
    }

    /**
     * the method creates a new Catalog object with a given name which will be assigned to the Catalog given as an argument.
     * @param catalog a Catalog object which will be manipulated through different actions.
     * @param args the arguments of the command
     * @return the new empty Catalog
     * @throws InvalidNumberOfArgumentsException if the user writes down arguments besides the command's name, the custom exception will be thrown.
     */
    @Override
    public Catalog execute(Catalog catalog, String... args) throws InvalidNumberOfArgumentsException {
        if(args.length!=1) {
            throw new InvalidNumberOfArgumentsException();
        }
        catalog = new Catalog(args[0]);
        System.out.println("Created new catalog named '" + args[0] + "'.");
        return catalog;
    }

    /**
     * Prints the command's name and the argument it needs in order to run properly.
     * @return a string representing an indication on how to run the command.
     */
    @Override
    public String toString() {
        return getName();
    }
}
