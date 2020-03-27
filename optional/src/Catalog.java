import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The Catalog class implements Serializable in order to convert the state of the objects into byte streams.
 */
public class Catalog implements Serializable {

    /**
     * Static int for associating unique IDs to added documents.
     */
    private static int id = 0;
    private String name;
    private List<Document> documents;


    public Catalog(String name) {
        this.name = name;
        this.documents = new ArrayList<Document>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) throws DuplicateDocumentException {
        List<String> list = documents.stream().map(Document::getName).collect(Collectors.toList());
        if(documents.stream().anyMatch(doc -> (documents.lastIndexOf(doc) != documents.indexOf(doc))) || list.stream().anyMatch(docName -> list.indexOf(docName) == list.lastIndexOf(docName))) {
            throw new DuplicateDocumentException();
        }
        this.documents = documents;
        id = 0;
        for (Document document : documents) {
            document.setId(id++);
        }
    }

    public Document getDocument(String documentName) throws CouldntFindInCatalogException {
        if(documents.stream().noneMatch(doc -> (doc.getName().equals(documentName)))) {
            throw new CouldntFindInCatalogException();
        }
        return documents.stream().filter(doc -> (doc.getName().equals(documentName))).collect(Collectors.toList()).get(0);
    }

    public boolean save(String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

            out.writeObject(this);
            out.close();
            fileOutputStream.close();
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean saveAsText(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter out = new PrintWriter(fileWriter);

            out.println(this.name);
            out.println(this.getNumberOfDocuments());

            for(Document doc : getDocuments()){
                out.println(doc.getPath());
                out.println(doc.getName());
                out.println(doc.getId());
                out.println(doc.getTags().size());
                for(Map.Entry<String, String> entry : doc.getTags().entrySet()){
                    out.println(entry.getKey());
                    out.println(entry.getValue());
                }
            }

            fileWriter.close();
            out.close();

            System.out.println("Catalog saved successfully.");
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static Catalog loadText(String filenName) throws DuplicateDocumentException {
        Catalog catalog = null;
        try {
            FileReader fileReader = new FileReader(filenName);
            BufferedReader in = new BufferedReader(fileReader);

            String line = in.readLine();
            catalog = new Catalog(line);

            int numberOfDocuments = Integer.parseInt(in.readLine());
            for (int i = 0; i < numberOfDocuments; i++) {
                Document document = null;
                String path = in.readLine();
                if (path.startsWith("http")) {
                    document = new ExternalDocument(in.readLine(), path);
                } else {
                    document = new LocalDocument(in.readLine(), path);
                }
                document.setId(Integer.parseInt(in.readLine()));
                int numberOfTags = Integer.parseInt(in.readLine());
                Map<String, String> tags = new HashMap<String, String>();
                for (int j = 0; j < numberOfTags; j++) {
                    tags.put(in.readLine(), in.readLine());
                }
                document.setTags(tags);
                catalog.addDocument(document);
            }

            in.close();
            fileReader.close();

            System.out.println("Catalog loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return catalog;
    }

    /**
     * loads the catalog from an external file
     * @param filenName loads the catalog from an external file
     * @return
     */
    public static Catalog load(String filenName) {
        Catalog catalog = null;
        try {
            FileInputStream fileOutputStream = new FileInputStream(filenName);
            ObjectInputStream in = new ObjectInputStream(fileOutputStream);

            catalog = (Catalog) in.readObject();
            in.close();
            fileOutputStream.close();
        }
        catch (IOException | ClassNotFoundException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return catalog;
    }


    public void addDocument(Document document) throws DuplicateDocumentException {
        if(documents.contains(document) || documents.stream().anyMatch(doc -> doc.getName().equals(document.getName()))) {
            throw new DuplicateDocumentException();
        }
        documents.add(document);
        documents.get(documents.indexOf(document)).setId(id++);
    }

    public Document getDocumentByName(String documentName) throws CouldntFindInCatalogException {
        List<Document> list = documents.stream().filter(document -> document.getName().equals(documentName)).collect(Collectors.toList());
        if(list.isEmpty()) {
            throw new CouldntFindInCatalogException();
        }
        return list.get(0);
    }

    public Document getDocumentById(int id) throws CouldntFindInCatalogException {
        List<Document> list = documents.stream().filter(document -> document.getId() == id).collect(Collectors.toList());
        if(list.isEmpty()) {
            throw new CouldntFindInCatalogException();
        }
        return list.get(0);
    }

    public int getDocumentId(Document document) throws CouldntFindInCatalogException {
        if(!documents.contains(document)) {
            //there should be an exception thrown here
            throw new CouldntFindInCatalogException();
        }
        return documents.get(documents.lastIndexOf(document)).getId();
    }

    public int getDocumentId(String documentName) throws CouldntFindInCatalogException {
        List<Document> list = documents.stream().filter(document -> document.getName().equals(documentName)).collect(Collectors.toList());
        if(list.isEmpty()) {
            //there should be an exception thrown here
            throw new CouldntFindInCatalogException();
        }
        return list.get(0).getId();
    }

    public void printDocumentsInfo() {
        for (Document document : documents) {
            System.out.println("Document " + name + " info:");
            for(Map.Entry<String,String> entry : document.getTags().entrySet()) {
                System.out.println("    " + entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public int getNumberOfDocuments() {
        return this.getDocuments().size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        documents.forEach(document -> stringBuilder.append("    - ").append(document).append('\n'));

        return "Catalog '" + name + "' contains: \n" + stringBuilder.toString();
    }
}
