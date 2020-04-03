package ro.info.uaic.georgeboghez.Commands;
import ro.info.uaic.georgeboghez.CatalogAndDocuments.*;
import ro.info.uaic.georgeboghez.Exceptions.*;

/**
 * The class extends Command and saves a Catalog object as a local file.
 */
public class SaveCommand extends Command {
    public SaveCommand(String name) {
        super(name);
    }

    /**
     * it calls Catalog's saveAsText method in order to save the catalog as a local file.
     * @param catalog a Catalog object which will be manipulated through different actions.
     * @param args the arguments of the command
     * @return the unmodified catalog
     * @throws NullCatalogException if no catalog was previously created or loaded, the custom exception will be thrown.
     * @throws InvalidNumberOfArgumentsException if the user writes down arguments besides the command's name, the custom exception will be thrown.
     */
    @Override
    public Catalog execute(Catalog catalog, String... args) throws NullCatalogException, InvalidNumberOfArgumentsException {
        if(catalog == null) {
            throw new NullCatalogException();
        }
        else if(args.length != 1){
            throw new InvalidNumberOfArgumentsException();
        }

        catalog.saveAsText(args[0]);
        return catalog;
    }

    /**
     * Prints the command's name and the argument it needs in order to run properly.
     * @return a string representing an indication on how to run the command.
     */
    @Override
    public String toString() {
        return getName() + " [absolute path]";
    }
}
