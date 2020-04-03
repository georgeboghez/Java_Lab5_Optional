package ro.info.uaic.georgeboghez;

import ro.info.uaic.georgeboghez.CatalogAndDocuments.*;
import ro.info.uaic.georgeboghez.Commands.*;
import ro.info.uaic.georgeboghez.Exceptions.*;
import java.io.IOException;
import java.util.Scanner;
//import java.io.File;
//import java.io.FileWriter;

public class Main {
    /**
     * It solely calls the run method.
     * @param args
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * Inside a loop input from the user is waited representing a command which is executed in the said loop. It stops when the command 'quit' is introduced.
     */
    public static void run() {

//        String homedirPath = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
//        ExternalDocument labURL = new ExternalDocument("LabURL","https://profs.info.uaic.ro/~acf/java/labs/lab_05.html");
//        new FileWriter(new File(homedirPath + "\\image.png")); // only a proof of work
//        LocalDocument localDocument = new LocalDocument("PNGFile",homedirPath + "\\image.png");
//        Catalog cat = new Catalog("c1");
//        cat.addDocument(labURL);
//        cat.addDocument(localDocument);
//        cat.saveAsText(homedirPath + "\\catalog_text_c1");
//        Catalog catalog2 = Catalog.loadText(homedirPath + "\\catalog_text_c1");
//        System.out.println(catalog2);
//        catalog2.getDocument("LabURL").openDocument();
//        catalog2.getDocument("PNGFile").openDocument();


        Shell shell = createShell();
        Scanner scanner = new Scanner(System.in);
        Catalog catalog = null;
        boolean loop = true;
        while(loop) {
            System.out.print(" > ");
            String[] commandAndArgs = scanner.nextLine().split(" ", 3);
            try {
                if(commandAndArgs[0].equals("commands")) {
                    System.out.println(shell);
                }
                else if(commandAndArgs[0].equals("quit")) {
                    loop = false;
                }
                else if (commandAndArgs.length == 1){
                    catalog = shell.getCommand(commandAndArgs[0]).execute(catalog);
                }
                else if(commandAndArgs.length == 2) {
                    catalog = shell.getCommand(commandAndArgs[0]).execute(catalog, commandAndArgs[1]);
                }
                else {
                    catalog = shell.getCommand(commandAndArgs[0]).execute(catalog, commandAndArgs[1], commandAndArgs[2]);
                }
            }
            catch (CommandNotFoundException | NullCatalogException | InvalidNumberOfArgumentsException | IOException | InexistentFileException | DuplicateDocumentException | CouldntFindInCatalogException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Creates a new shell and adds commands to it
     * @return a Shell object
     */
    private static Shell createShell() {
        Shell shell = new Shell();
        shell.addCommand(new NewCatalogCommand("new"));
        shell.addCommand(new ListCommand("list"));
        shell.addCommand(new ReportHtmlCommand("html"));
        shell.addCommand(new SaveCommand("save"));
        shell.addCommand(new LoadCommand("load"));
        shell.addCommand(new ViewCommand("view"));
        shell.addCommand(new AddDocumentCommand("add"));
        return shell;
    }
}
