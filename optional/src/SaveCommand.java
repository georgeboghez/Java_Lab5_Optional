public class SaveCommand extends Command {
    public SaveCommand(String name) {
        super(name);
    }

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
    @Override
    public String toString() {
        return getName() + " [absolute path]";
    }
}
