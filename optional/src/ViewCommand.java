public class ViewCommand extends Command {
    public ViewCommand(String name) {
        super(name);
    }

    @Override
    public Catalog execute(Catalog catalog, String... args) throws InvalidNumberOfArgumentsException, CouldntFindInCatalogException {
        if(args.length != 1) {
            throw new InvalidNumberOfArgumentsException();
        }

        catalog.getDocument(args[0]).openDocument();

        return catalog;
    }

    @Override
    public String toString() {
        return getName() + " [document name]";
    }
}
