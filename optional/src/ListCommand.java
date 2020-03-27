public class ListCommand extends Command {


    public ListCommand(String name) {
        super(name);
    }

    @Override
    public Catalog execute(Catalog catalog, String... args) throws InvalidNumberOfArgumentsException {
        if(args.length != 0) {
            throw new InvalidNumberOfArgumentsException();
        }

        System.out.println(catalog);

        return catalog;
    }

    @Override
    public String toString() {
        return getName();
    }
}
