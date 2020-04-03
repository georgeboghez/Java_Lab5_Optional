package ro.info.uaic.georgeboghez.Commands;

import ro.info.uaic.georgeboghez.CatalogAndDocuments.*;
import ro.info.uaic.georgeboghez.Exceptions.*;

/**
 * The class extends Command and lists the contents the catalog.
 */
public class ListCommand extends Command {
    public ListCommand(String name) {
        super(name);
    }

    /**
     * The implemented method which prints the given catalog.
     * @param catalog a Catalog object which will be manipulated through different actions.
     * @param args the arguments of the command
     * @return the unmodified catalog
     * @throws InvalidNumberOfArgumentsException if the user writes down arguments besides the command's name, the custom exception will be thrown.
     */
    @Override
    public Catalog execute(Catalog catalog, String... args) throws InvalidNumberOfArgumentsException {
        if(args.length != 0) {
            throw new InvalidNumberOfArgumentsException();
        }

        System.out.println(catalog);

        return catalog;
    }

    /**
     * Prints the commands name
     * @return a string representing the commands name
     */
    @Override
    public String toString() {
        return getName();
    }
}
