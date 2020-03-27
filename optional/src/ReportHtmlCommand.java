import javax.swing.filechooser.FileSystemView;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ReportHtmlCommand extends Command {
    public ReportHtmlCommand(String name) {
        super(name);
    }

    @Override
    public Catalog execute(Catalog catalog, String... args) throws NullCatalogException, InvalidNumberOfArgumentsException {
        if (catalog == null) {
            throw new NullCatalogException();
        } else if (args.length != 0) {
            throw new InvalidNumberOfArgumentsException();
        }

        String homedirPath = FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
        String fileName = homedirPath + "\\HTML_REPORT_" + catalog.getName() + ".html";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter out = new PrintWriter(fileWriter);

            out.println("<!DOCTYPE html>\n");
            out.println("<html>\n");
            out.println("<head>\n");
            out.println("\t<title>" + catalog.getName() + " Report</title>\n");
            out.println("</head>\n");
            out.println("<body>\n");
            out.println("<h1>" + catalog.getName() + " contents: </h1>\n");
            out.println("<ol>\n");
            for (Document document : catalog.getDocuments()) {
                if(document.getPath().startsWith("http"))
                    out.println("<li>" + document.getName() + " <a href=\"" + document.getPath() + "\">(" + document.getPath() + ")</a></li>\n");
                else
                    out.println("<li>" + document.getName() + " (" + document.getPath() + ")</li>\n");
                out.println("<ul>\n");
                for (Map.Entry<String,String> entry : document.getTags().entrySet()) {
                    out.println("<li>" + entry.getKey() + " : " + entry.getValue() + "</li>\n");
                }
                out.println("</ul>\n");
            }
            out.println("</ol>\n");
            out.println("</body>\n");
            out.println("</html>\n");

            fileWriter.close();
            out.close();
            System.out.println("Report HTML " + fileName + " created successfully.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return catalog;
    }

    @Override
    public String toString() {
        return getName();
    }
}
