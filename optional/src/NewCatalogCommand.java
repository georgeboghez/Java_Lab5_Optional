public class NewCatalogCommand extends Command {
    public NewCatalogCommand(String name) {
        super(name);
    }

    @Override
    public Catalog execute(Catalog catalog, String... args) throws InvalidNumberOfArgumentsException {
        if(args.length!=1) {
            throw new InvalidNumberOfArgumentsException();
        }
        catalog = new Catalog(args[0]);
        System.out.println("Created new catalog named '" + args[0] + "'.");
        return catalog;
    }

    @Override
    public String toString() {
        return getName();
    }
}
